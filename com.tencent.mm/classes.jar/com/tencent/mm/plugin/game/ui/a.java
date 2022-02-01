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
  private static int sem = 500;
  protected Context mContext;
  protected LinkedList<T> rYm;
  private a sej;
  protected boolean sek = false;
  private f<String, Bitmap> sel;
  private av sen = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(41856);
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(41856);
      return false;
    }
  }, false);
  private final k.a seo = new k.a()
  {
    public final void a(String paramAnonymousString, m paramAnonymousm)
    {
      AppMethodBeat.i(41857);
      a.a(a.this).stopTimer();
      paramAnonymousString = a.a(a.this);
      long l = a.sem;
      paramAnonymousString.av(l, l);
      AppMethodBeat.o(41857);
    }
  };
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.rYm = new LinkedList();
    this.sel = new b(20, getClass());
    com.tencent.mm.plugin.s.a.cZQ().add(this.seo);
  }
  
  protected final Bitmap acO(String paramString)
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
          if (!this.sel.aN(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.sel.get(paramString);
          if (localBitmap == null) {
            break;
          }
          localObject = localBitmap;
        } while (!localBitmap.isRecycled());
        localBitmap = h.c(paramString, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
        localObject = localBitmap;
      } while (localBitmap == null);
      localObject = localBitmap;
    } while (localBitmap.isRecycled());
    this.sel.o(paramString, localBitmap);
    return localBitmap;
  }
  
  public void aq(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.sej != null) {
        this.rYm.size();
      }
      return;
    }
    this.rYm.addAll(paramLinkedList);
    if (this.sej != null) {
      this.rYm.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void ar(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.sej != null) {
        this.rYm.size();
      }
      return;
    }
    this.rYm = paramLinkedList;
    if (this.sej != null) {
      this.rYm.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.rYm != null) {
      this.rYm.clear();
    }
    if (this.sel != null) {
      this.sel.a(new f.a() {});
    }
    this.sel = null;
    com.tencent.mm.plugin.s.a.cZQ().remove(this.seo);
  }
  
  public int getCount()
  {
    return this.rYm.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.rYm.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.a
 * JD-Core Version:    0.7.0.1
 */