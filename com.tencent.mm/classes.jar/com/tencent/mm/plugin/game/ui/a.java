package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public abstract class a<T>
  extends BaseAdapter
{
  private static int ukF = 500;
  protected Context mContext;
  protected LinkedList<T> udU;
  private a ukC;
  protected boolean ukD = false;
  private f<String, Bitmap> ukE;
  private av ukG = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(41856);
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(41856);
      return false;
    }
  }, false);
  private final k.a ukH = new k.a()
  {
    public final void a(String paramAnonymousString, m paramAnonymousm)
    {
      AppMethodBeat.i(41857);
      a.a(a.this).stopTimer();
      paramAnonymousString = a.a(a.this);
      long l = a.ukF;
      paramAnonymousString.az(l, l);
      AppMethodBeat.o(41857);
    }
  };
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.udU = new LinkedList();
    this.ukE = new b(20, getClass());
    com.tencent.mm.plugin.s.a.dxQ().add(this.ukH);
  }
  
  public void aA(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.ukC != null) {
        this.udU.size();
      }
      return;
    }
    this.udU = paramLinkedList;
    if (this.ukC != null) {
      this.udU.size();
    }
    super.notifyDataSetChanged();
  }
  
  protected final Bitmap ami(String paramString)
  {
    Object localObject;
    if (bt.isNullOrNil(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      do
      {
        do
        {
          return localObject;
          if (!this.ukE.aM(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.ukE.get(paramString);
          if (localBitmap == null) {
            break;
          }
          localObject = localBitmap;
        } while (!localBitmap.isRecycled());
        localBitmap = h.c(paramString, 1, com.tencent.mm.cc.a.getDensity(this.mContext));
        localObject = localBitmap;
      } while (localBitmap == null);
      localObject = localBitmap;
    } while (localBitmap.isRecycled());
    this.ukE.q(paramString, localBitmap);
    return localBitmap;
  }
  
  public void az(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.ukC != null) {
        this.udU.size();
      }
      return;
    }
    this.udU.addAll(paramLinkedList);
    if (this.ukC != null) {
      this.udU.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.udU != null) {
      this.udU.clear();
    }
    if (this.ukE != null) {
      this.ukE.a(new f.a() {});
    }
    this.ukE = null;
    com.tencent.mm.plugin.s.a.dxQ().remove(this.ukH);
  }
  
  public int getCount()
  {
    return this.udU.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.udU.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.a
 * JD-Core Version:    0.7.0.1
 */