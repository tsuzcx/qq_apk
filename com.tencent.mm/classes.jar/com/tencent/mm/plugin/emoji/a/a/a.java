package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public abstract class a
  extends BaseAdapter
{
  private final String TAG = "MicroMsg.BaseEmojiListAdapter";
  private final String gLh = "lock";
  protected Context mContext;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> qXJ;
  public AbsListView qXY;
  public c qXZ;
  public j.a qYa;
  protected volatile boolean qYb = false;
  private int qYc = 0;
  private int qYd = 0;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.qXJ = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.qYk == f.a.qYt) {
      return paramf.qYm.ID + "_cell";
    }
    return paramf.qYl.ProductID;
  }
  
  public abstract void FK(int paramInt);
  
  public abstract void FL(int paramInt);
  
  public abstract void FM(int paramInt);
  
  public f FN(int paramInt)
  {
    if (this.qXZ == null) {
      return null;
    }
    return this.qXZ.FS(paramInt);
  }
  
  protected c a(g paramg)
  {
    return new c(paramg);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.qXZ == paramc)) {
      return;
    }
    this.qXZ = paramc.cFp();
    notifyDataSetChanged();
  }
  
  protected final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {
      return;
    }
    paramf.setStatus(paramInt);
    this.qXZ.de(paramString, paramInt);
  }
  
  public final com.tencent.mm.plugin.emoji.a.a ama(String paramString)
  {
    if (this.qXJ == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.qXJ.get(paramString);
  }
  
  public abstract View b(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final void b(final g paramg)
  {
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108349);
        if (paramg == null)
        {
          AppMethodBeat.o(108349);
          return;
        }
        a.a(a.this, a.this.a(paramg));
        a.this.notifyDataSetChanged();
        AppMethodBeat.o(108349);
      }
    });
  }
  
  protected void cFj()
  {
    if (this.qXJ != null) {
      this.qXJ.clear();
    }
    super.notifyDataSetChanged();
    this.qYb = true;
  }
  
  public abstract int cFk();
  
  public abstract int cFl();
  
  public abstract int cFm();
  
  public void clear()
  {
    if (this.qXJ != null)
    {
      this.qXJ.clear();
      this.qXJ = null;
    }
    if (this.qXZ != null)
    {
      this.qXZ.clear();
      this.qXZ = null;
    }
    this.qYb = false;
  }
  
  protected abstract com.tencent.mm.plugin.emoji.a.a d(Context paramContext, View paramView);
  
  public void dc(String paramString, int paramInt)
  {
    if ((this.qXJ == null) || (this.qXZ == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.qXZ.amb(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.qXZ != null) && (((f)localObject).mStatus == -1))
      {
        Log.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.qXZ.qYi, this.qXZ.amf(paramString), this.qXZ.amd(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = ama(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.cFh();
          return;
        }
      }
    }
  }
  
  public final void dd(String paramString, int paramInt)
  {
    if ((this.qXJ == null) || (this.qXZ == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.qXZ.amb(paramString);
      if (localObject != null)
      {
        if ((paramInt >= 0) && (paramInt < 100))
        {
          a((f)localObject, paramString, 6);
          ((f)localObject).HH = paramInt;
        }
        if (paramInt >= 100) {
          a((f)localObject, paramString, 7);
        }
      }
      com.tencent.mm.plugin.emoji.a.a locala = ama(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.cFh();
          return;
        }
      }
    }
  }
  
  public int getCount()
  {
    if (this.qXZ == null) {
      return 0;
    }
    return this.qXZ.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.emoji.a.a locala1 = null;
    if (paramView != null) {
      locala1 = (com.tencent.mm.plugin.emoji.a.a)paramView.getTag();
    }
    f localf = FN(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = d(this.mContext, paramView);
      localView = locala2.getRoot();
      this.qXJ.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.qWK = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.cFh();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!Util.isNullOrNil(a(localf)))
      {
        if (this.qXJ.containsValue(locala1)) {
          this.qXJ.remove(locala1.getProductId());
        }
        this.qXJ.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.qYb = false;
    if (this.qXZ != null)
    {
      this.qXZ.notifyDataSetChanged();
      i = this.qYc;
      this.qYc = (i + 1);
      Log.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.qYd;
    this.qYd = (i + 1);
    Log.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    cFj();
  }
  
  public final void refreshView()
  {
    if (!this.qYb) {
      return;
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */