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
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public abstract class a<T>
  extends BaseAdapter
{
  private static int uwc = 500;
  protected Context mContext;
  protected LinkedList<T> upc;
  private a uvZ;
  protected boolean uwa = false;
  private f<String, Bitmap> uwb;
  private aw uwd = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(41856);
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(41856);
      return false;
    }
  }, false);
  private final k.a uwe = new k.a()
  {
    public final void a(String paramAnonymousString, m paramAnonymousm)
    {
      AppMethodBeat.i(41857);
      a.a(a.this).stopTimer();
      paramAnonymousString = a.a(a.this);
      long l = a.uwc;
      paramAnonymousString.ay(l, l);
      AppMethodBeat.o(41857);
    }
  };
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.upc = new LinkedList();
    this.uwb = new b(20, getClass());
    com.tencent.mm.plugin.s.a.dBg().add(this.uwe);
  }
  
  public void aA(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.uvZ != null) {
        this.upc.size();
      }
      return;
    }
    this.upc = paramLinkedList;
    if (this.uvZ != null) {
      this.upc.size();
    }
    super.notifyDataSetChanged();
  }
  
  protected final Bitmap ani(String paramString)
  {
    Object localObject;
    if (bu.isNullOrNil(paramString)) {
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
          if (!this.uwb.aM(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.uwb.get(paramString);
          if (localBitmap == null) {
            break;
          }
          localObject = localBitmap;
        } while (!localBitmap.isRecycled());
        localBitmap = h.c(paramString, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
        localObject = localBitmap;
      } while (localBitmap == null);
      localObject = localBitmap;
    } while (localBitmap.isRecycled());
    this.uwb.q(paramString, localBitmap);
    return localBitmap;
  }
  
  public void az(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.uvZ != null) {
        this.upc.size();
      }
      return;
    }
    this.upc.addAll(paramLinkedList);
    if (this.uvZ != null) {
      this.upc.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.upc != null) {
      this.upc.clear();
    }
    if (this.uwb != null) {
      this.uwb.a(new f.a() {});
    }
    this.uwb = null;
    com.tencent.mm.plugin.s.a.dBg().remove(this.uwe);
  }
  
  public int getCount()
  {
    return this.upc.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.upc.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.a
 * JD-Core Version:    0.7.0.1
 */