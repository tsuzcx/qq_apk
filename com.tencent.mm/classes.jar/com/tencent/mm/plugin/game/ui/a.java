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
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public abstract class a<T>
  extends BaseAdapter
{
  private static int tmg = 500;
  protected Context mContext;
  protected LinkedList<T> tge;
  private a tmd;
  protected boolean tme = false;
  private f<String, Bitmap> tmf;
  private au tmh = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(41856);
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(41856);
      return false;
    }
  }, false);
  private final k.a tmi = new k.a()
  {
    public final void a(String paramAnonymousString, m paramAnonymousm)
    {
      AppMethodBeat.i(41857);
      a.a(a.this).stopTimer();
      paramAnonymousString = a.a(a.this);
      long l = a.tmg;
      paramAnonymousString.au(l, l);
      AppMethodBeat.o(41857);
    }
  };
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.tge = new LinkedList();
    this.tmf = new b(20, getClass());
    com.tencent.mm.plugin.s.a.dny().add(this.tmi);
  }
  
  protected final Bitmap ahG(String paramString)
  {
    Object localObject;
    if (bs.isNullOrNil(paramString)) {
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
          if (!this.tmf.aK(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.tmf.get(paramString);
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
    this.tmf.o(paramString, localBitmap);
    return localBitmap;
  }
  
  public void ax(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.tmd != null) {
        this.tge.size();
      }
      return;
    }
    this.tge.addAll(paramLinkedList);
    if (this.tmd != null) {
      this.tge.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void ay(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.tmd != null) {
        this.tge.size();
      }
      return;
    }
    this.tge = paramLinkedList;
    if (this.tmd != null) {
      this.tge.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.tge != null) {
      this.tge.clear();
    }
    if (this.tmf != null) {
      this.tmf.a(new f.a() {});
    }
    this.tmf = null;
    com.tencent.mm.plugin.s.a.dny().remove(this.tmi);
  }
  
  public int getCount()
  {
    return this.tge.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.tge.get(paramInt);
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