package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.model.r.a;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public abstract class a
  extends BaseAdapter
{
  private final String TAG = "MicroMsg.BaseEmojiListAdapter";
  private final String lYN = "lock";
  private Context mContext;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> xHb;
  public AbsListView xHq;
  public c xHr;
  public r.a xHs;
  protected volatile boolean xHt = false;
  private int xHu = 0;
  private int xHv = 0;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.xHb = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.xHD == f.a.xHN) {
      return paramf.xHF.hjP + "_cell";
    }
    return paramf.xHE.ProductID;
  }
  
  public abstract void JZ(int paramInt);
  
  public abstract void Ka(int paramInt);
  
  public abstract void Kb(int paramInt);
  
  public f Kd(int paramInt)
  {
    if (this.xHr == null) {
      return null;
    }
    return this.xHr.Ki(paramInt);
  }
  
  protected c a(m paramm)
  {
    return new c(paramm);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.xHr == paramc)) {
      return;
    }
    this.xHr = paramc.dym();
    notifyDataSetChanged();
  }
  
  protected final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {
      return;
    }
    paramf.setStatus(paramInt);
    this.xHr.dZ(paramString, paramInt);
  }
  
  public final com.tencent.mm.plugin.emoji.a.a anM(String paramString)
  {
    if (this.xHb == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.xHb.get(paramString);
  }
  
  public abstract View b(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final void b(final m paramm)
  {
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108349);
        if (paramm == null)
        {
          AppMethodBeat.o(108349);
          return;
        }
        a.a(a.this, a.this.a(paramm));
        a.this.notifyDataSetChanged();
        AppMethodBeat.o(108349);
      }
    });
  }
  
  public void clear()
  {
    if (this.xHb != null)
    {
      this.xHb.clear();
      this.xHb = null;
    }
    if (this.xHr != null)
    {
      this.xHr.clear();
      this.xHr = null;
    }
    this.xHt = false;
  }
  
  protected abstract com.tencent.mm.plugin.emoji.a.a d(Context paramContext, View paramView);
  
  public void dX(String paramString, int paramInt)
  {
    if ((this.xHb == null) || (this.xHr == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.xHr.anN(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.xHr != null) && (((f)localObject).mStatus == -1))
      {
        Log.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.xHr.xHB, this.xHr.anR(paramString), this.xHr.anP(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = anM(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.dye();
          return;
        }
      }
    }
  }
  
  public final void dY(String paramString, int paramInt)
  {
    if ((this.xHb == null) || (this.xHr == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.xHr.anN(paramString);
      if (localObject != null)
      {
        if ((paramInt >= 0) && (paramInt < 100))
        {
          a((f)localObject, paramString, 6);
          ((f)localObject).boE = paramInt;
        }
        if (paramInt >= 100) {
          a((f)localObject, paramString, 7);
        }
      }
      com.tencent.mm.plugin.emoji.a.a locala = anM(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.dye();
          return;
        }
      }
    }
  }
  
  protected void dyg()
  {
    if (this.xHb != null) {
      this.xHb.clear();
    }
    super.notifyDataSetChanged();
    this.xHt = true;
  }
  
  public abstract int dyh();
  
  public abstract int dyi();
  
  public abstract int dyj();
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  public int getCount()
  {
    if (this.xHr == null) {
      return 0;
    }
    return this.xHr.size();
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
    f localf = Kd(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = d(this.mContext, paramView);
      localView = locala2.getRoot();
      this.xHb.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.xFY = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.dye();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!Util.isNullOrNil(a(localf)))
      {
        if (this.xHb.containsValue(locala1)) {
          this.xHb.remove(locala1.getProductId());
        }
        this.xHb.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.xHt = false;
    if (this.xHr != null)
    {
      this.xHr.notifyDataSetChanged();
      i = this.xHu;
      this.xHu = (i + 1);
      Log.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.xHv;
    this.xHv = (i + 1);
    Log.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    dyg();
  }
  
  public final void refreshView()
  {
    if (!this.xHt) {
      return;
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */