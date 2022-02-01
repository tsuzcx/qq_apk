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
  private static int CSn = 500;
  protected LinkedList<T> CLy;
  private a CSk;
  protected boolean CSl = false;
  private f<String, Bitmap> CSm;
  private MTimerHandler CSo = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(41856);
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(41856);
      return false;
    }
  }, false);
  private final MStorage.IOnStorageChange CSp = new MStorage.IOnStorageChange()
  {
    public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
    {
      AppMethodBeat.i(41857);
      a.a(a.this).stopTimer();
      a.a(a.this).startTimer(a.CSn);
      AppMethodBeat.o(41857);
    }
  };
  protected Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.CLy = new LinkedList();
    this.CSm = new b(20, getClass());
    com.tencent.mm.plugin.ab.a.fmz().add(this.CSp);
  }
  
  protected final Bitmap aKl(String paramString)
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
          if (!this.CSm.check(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.CSm.get(paramString);
          if (localBitmap == null) {
            break;
          }
          localObject = localBitmap;
        } while (!localBitmap.isRecycled());
        localBitmap = h.c(paramString, 1, com.tencent.mm.ci.a.getDensity(this.mContext));
        localObject = localBitmap;
      } while (localBitmap == null);
      localObject = localBitmap;
    } while (localBitmap.isRecycled());
    this.CSm.q(paramString, localBitmap);
    return localBitmap;
  }
  
  public void bn(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.CSk != null) {
        this.CLy.size();
      }
      return;
    }
    this.CLy.addAll(paramLinkedList);
    if (this.CSk != null) {
      this.CLy.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void bo(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.CSk != null) {
        this.CLy.size();
      }
      return;
    }
    this.CLy = paramLinkedList;
    if (this.CSk != null) {
      this.CLy.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.CLy != null) {
      this.CLy.clear();
    }
    if (this.CSm != null) {
      this.CSm.a(new f.a() {});
    }
    this.CSm = null;
    com.tencent.mm.plugin.ab.a.fmz().remove(this.CSp);
  }
  
  public int getCount()
  {
    return this.CLy.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.CLy.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.a
 * JD-Core Version:    0.7.0.1
 */