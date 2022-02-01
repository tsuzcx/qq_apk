package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public abstract class a
  extends BaseAdapter
{
  private final String TAG = "MicroMsg.BaseEmojiListAdapter";
  private final String fJR = "lock";
  protected Context mContext;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> oXJ;
  public AbsListView oXY;
  public c oXZ;
  public j.a oYa;
  protected volatile boolean oYb = false;
  private int oYc = 0;
  private int oYd = 0;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.oXJ = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.oYk == f.a.oYt) {
      return paramf.oYm.ID + "_cell";
    }
    return paramf.oYl.ProductID;
  }
  
  public abstract void Bh(int paramInt);
  
  public abstract void Bi(int paramInt);
  
  public abstract void Bj(int paramInt);
  
  public f Bk(int paramInt)
  {
    if (this.oXZ == null) {
      return null;
    }
    return this.oXZ.Bp(paramInt);
  }
  
  public final com.tencent.mm.plugin.emoji.a.a XA(String paramString)
  {
    if (this.oXJ == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.oXJ.get(paramString);
  }
  
  protected c a(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    return new c(paramf);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.oXZ == paramc)) {
      return;
    }
    this.oXZ = paramc.cbJ();
    notifyDataSetChanged();
  }
  
  protected final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {
      return;
    }
    paramf.setStatus(paramInt);
    this.oXZ.cR(paramString, paramInt);
  }
  
  public abstract View b(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final void b(final com.tencent.mm.plugin.emoji.model.f paramf)
  {
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108349);
        if (paramf == null)
        {
          AppMethodBeat.o(108349);
          return;
        }
        a.a(a.this, a.this.a(paramf));
        a.this.notifyDataSetChanged();
        AppMethodBeat.o(108349);
      }
    });
  }
  
  public void cP(String paramString, int paramInt)
  {
    if ((this.oXJ == null) || (this.oXZ == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.oXZ.XB(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.oXZ != null) && (((f)localObject).mStatus == -1))
      {
        ac.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.oXZ.oYi, this.oXZ.XF(paramString), this.oXZ.XD(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = XA(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.cbB();
          return;
        }
      }
    }
  }
  
  public final void cQ(String paramString, int paramInt)
  {
    if ((this.oXJ == null) || (this.oXZ == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.oXZ.XB(paramString);
      if (localObject != null)
      {
        if ((paramInt >= 0) && (paramInt < 100))
        {
          a((f)localObject, paramString, 6);
          ((f)localObject).FG = paramInt;
        }
        if (paramInt >= 100) {
          a((f)localObject, paramString, 7);
        }
      }
      com.tencent.mm.plugin.emoji.a.a locala = XA(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.cbB();
          return;
        }
      }
    }
  }
  
  protected void cbD()
  {
    if (this.oXJ != null) {
      this.oXJ.clear();
    }
    super.notifyDataSetChanged();
    this.oYb = true;
  }
  
  public abstract int cbE();
  
  public abstract int cbF();
  
  public abstract int cbG();
  
  public void clear()
  {
    if (this.oXJ != null)
    {
      this.oXJ.clear();
      this.oXJ = null;
    }
    if (this.oXZ != null)
    {
      this.oXZ.clear();
      this.oXZ = null;
    }
    this.oYb = false;
  }
  
  protected abstract com.tencent.mm.plugin.emoji.a.a d(Context paramContext, View paramView);
  
  public int getCount()
  {
    if (this.oXZ == null) {
      return 0;
    }
    return this.oXZ.size();
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
    f localf = Bk(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = d(this.mContext, paramView);
      localView = locala2.getRoot();
      this.oXJ.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.oWK = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.cbB();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!bs.isNullOrNil(a(localf)))
      {
        if (this.oXJ.containsValue(locala1)) {
          this.oXJ.remove(locala1.getProductId());
        }
        this.oXJ.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.oYb = false;
    if (this.oXZ != null)
    {
      this.oXZ.notifyDataSetChanged();
      i = this.oYc;
      this.oYc = (i + 1);
      ac.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.oYd;
    this.oYd = (i + 1);
    ac.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    cbD();
  }
  
  public final void refreshView()
  {
    if (!this.oYb) {
      return;
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */