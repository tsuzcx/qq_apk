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
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.LinkedList;

public abstract class a<T>
  extends BaseAdapter
{
  private static int xOd = 500;
  protected Context mContext;
  protected LinkedList<T> xHv;
  private a xOa;
  protected boolean xOb = false;
  private f<String, Bitmap> xOc;
  private MTimerHandler xOe = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(41856);
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(41856);
      return false;
    }
  }, false);
  private final MStorage.IOnStorageChange xOf = new MStorage.IOnStorageChange()
  {
    public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
    {
      AppMethodBeat.i(41857);
      a.a(a.this).stopTimer();
      a.a(a.this).startTimer(a.xOd);
      AppMethodBeat.o(41857);
    }
  };
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.xHv = new LinkedList();
    this.xOc = new b(20, getClass());
    com.tencent.mm.plugin.r.a.eAS().add(this.xOf);
  }
  
  protected final Bitmap aAz(String paramString)
  {
    Object localObject;
    if (Util.isNullOrNil(paramString)) {
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
          if (!this.xOc.check(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.xOc.get(paramString);
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
    this.xOc.x(paramString, localBitmap);
    return localBitmap;
  }
  
  public void aU(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.xOa != null) {
        this.xHv.size();
      }
      return;
    }
    this.xHv.addAll(paramLinkedList);
    if (this.xOa != null) {
      this.xHv.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void aV(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.xOa != null) {
        this.xHv.size();
      }
      return;
    }
    this.xHv = paramLinkedList;
    if (this.xOa != null) {
      this.xHv.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.xHv != null) {
      this.xHv.clear();
    }
    if (this.xOc != null) {
      this.xOc.a(new f.a() {});
    }
    this.xOc = null;
    com.tencent.mm.plugin.r.a.eAS().remove(this.xOf);
  }
  
  public int getCount()
  {
    return this.xHv.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.xHv.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.a
 * JD-Core Version:    0.7.0.1
 */