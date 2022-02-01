package androidx.camera.core;

import android.util.SparseArray;
import androidx.c.a.b;
import androidx.c.a.b.a;
import androidx.c.a.b.c;
import androidx.camera.core.impl.am;
import androidx.camera.core.impl.bi;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class au
  implements am
{
  private String IT;
  private final List<Integer> IV;
  final SparseArray<b.a<ag>> Jh;
  final SparseArray<f<ag>> Ji;
  final List<ag> Jj;
  boolean mClosed;
  final Object mLock;
  
  au(List<Integer> paramList, String paramString)
  {
    AppMethodBeat.i(198281);
    this.mLock = new Object();
    this.Jh = new SparseArray();
    this.Ji = new SparseArray();
    this.Jj = new ArrayList();
    this.IT = null;
    this.mClosed = false;
    this.IV = paramList;
    this.IT = paramString;
    setup();
    AppMethodBeat.o(198281);
  }
  
  public final f<ag> aV(int paramInt)
  {
    AppMethodBeat.i(198284);
    synchronized (this.mLock)
    {
      if (this.mClosed)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("ImageProxyBundle already closed.");
        AppMethodBeat.o(198284);
        throw localIllegalStateException;
      }
    }
    Object localObject3 = (f)this.Ji.get(paramInt);
    if (localObject3 == null)
    {
      localObject3 = new IllegalArgumentException("ImageProxyBundle does not contain this id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(198284);
      throw ((Throwable)localObject3);
    }
    AppMethodBeat.o(198284);
    return localObject3;
  }
  
  final void close()
  {
    AppMethodBeat.i(198300);
    synchronized (this.mLock)
    {
      if (this.mClosed)
      {
        AppMethodBeat.o(198300);
        return;
      }
      Iterator localIterator = this.Jj.iterator();
      if (localIterator.hasNext()) {
        ((ag)localIterator.next()).close();
      }
    }
    this.Jj.clear();
    this.Ji.clear();
    this.Jh.clear();
    this.mClosed = true;
    AppMethodBeat.o(198300);
  }
  
  final void g(ag paramag)
  {
    AppMethodBeat.i(198295);
    Integer localInteger;
    synchronized (this.mLock)
    {
      if (this.mClosed)
      {
        AppMethodBeat.o(198295);
        return;
      }
      localInteger = (Integer)paramag.it().go().getTag(this.IT);
      if (localInteger == null)
      {
        paramag = new IllegalArgumentException("CaptureId is null.");
        AppMethodBeat.o(198295);
        throw paramag;
      }
    }
    b.a locala = (b.a)this.Jh.get(localInteger.intValue());
    if (locala != null)
    {
      this.Jj.add(paramag);
      locala.ap(paramag);
      AppMethodBeat.o(198295);
      return;
    }
    paramag = new IllegalArgumentException("ImageProxyBundle does not contain this id: ".concat(String.valueOf(localInteger)));
    AppMethodBeat.o(198295);
  }
  
  public final List<Integer> js()
  {
    AppMethodBeat.i(198287);
    List localList = Collections.unmodifiableList(this.IV);
    AppMethodBeat.o(198287);
    return localList;
  }
  
  final void setup()
  {
    AppMethodBeat.i(198305);
    synchronized (this.mLock)
    {
      Iterator localIterator = this.IV.iterator();
      if (localIterator.hasNext())
      {
        final int i = ((Integer)localIterator.next()).intValue();
        f localf = b.a(new b.c()
        {
          public final Object attachCompleter(b.a<ag> paramAnonymousa)
          {
            AppMethodBeat.i(198445);
            synchronized (au.this.mLock)
            {
              au.this.Jh.put(i, paramAnonymousa);
              paramAnonymousa = "getImageProxy(id: " + i + ")";
              AppMethodBeat.o(198445);
              return paramAnonymousa;
            }
          }
        });
        this.Ji.put(i, localf);
      }
    }
    AppMethodBeat.o(198305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.au
 * JD-Core Version:    0.7.0.1
 */