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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public abstract class a
  extends BaseAdapter
{
  private final String TAG = "MicroMsg.BaseEmojiListAdapter";
  private final String gds = "lock";
  protected Context mContext;
  public AbsListView pBI;
  public c pBJ;
  public j.a pBK;
  protected volatile boolean pBL = false;
  private int pBM = 0;
  private int pBN = 0;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> pBt;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.pBt = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.pBU == f.a.pCd) {
      return paramf.pBW.ID + "_cell";
    }
    return paramf.pBV.ProductID;
  }
  
  public abstract void BP(int paramInt);
  
  public abstract void BQ(int paramInt);
  
  public abstract void BR(int paramInt);
  
  public f BS(int paramInt)
  {
    if (this.pBJ == null) {
      return null;
    }
    return this.pBJ.BX(paramInt);
  }
  
  protected c a(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    return new c(paramf);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.pBJ == paramc)) {
      return;
    }
    this.pBJ = paramc.cgn();
    notifyDataSetChanged();
  }
  
  protected final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {
      return;
    }
    paramf.setStatus(paramInt);
    this.pBJ.cU(paramString, paramInt);
  }
  
  public final com.tencent.mm.plugin.emoji.a.a abh(String paramString)
  {
    if (this.pBt == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.pBt.get(paramString);
  }
  
  public abstract View b(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final void b(final com.tencent.mm.plugin.emoji.model.f paramf)
  {
    aq.f(new Runnable()
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
  
  public void cS(String paramString, int paramInt)
  {
    if ((this.pBt == null) || (this.pBJ == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.pBJ.abi(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.pBJ != null) && (((f)localObject).mStatus == -1))
      {
        ad.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.pBJ.pBS, this.pBJ.abm(paramString), this.pBJ.abk(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = abh(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.cgf();
          return;
        }
      }
    }
  }
  
  public final void cT(String paramString, int paramInt)
  {
    if ((this.pBt == null) || (this.pBJ == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.pBJ.abi(paramString);
      if (localObject != null)
      {
        if ((paramInt >= 0) && (paramInt < 100))
        {
          a((f)localObject, paramString, 6);
          ((f)localObject).Hx = paramInt;
        }
        if (paramInt >= 100) {
          a((f)localObject, paramString, 7);
        }
      }
      com.tencent.mm.plugin.emoji.a.a locala = abh(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.cgf();
          return;
        }
      }
    }
  }
  
  protected void cgh()
  {
    if (this.pBt != null) {
      this.pBt.clear();
    }
    super.notifyDataSetChanged();
    this.pBL = true;
  }
  
  public abstract int cgi();
  
  public abstract int cgj();
  
  public abstract int cgk();
  
  public void clear()
  {
    if (this.pBt != null)
    {
      this.pBt.clear();
      this.pBt = null;
    }
    if (this.pBJ != null)
    {
      this.pBJ.clear();
      this.pBJ = null;
    }
    this.pBL = false;
  }
  
  protected abstract com.tencent.mm.plugin.emoji.a.a d(Context paramContext, View paramView);
  
  public int getCount()
  {
    if (this.pBJ == null) {
      return 0;
    }
    return this.pBJ.size();
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
    f localf = BS(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = d(this.mContext, paramView);
      localView = locala2.getRoot();
      this.pBt.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.pAu = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.cgf();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!bt.isNullOrNil(a(localf)))
      {
        if (this.pBt.containsValue(locala1)) {
          this.pBt.remove(locala1.getProductId());
        }
        this.pBt.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.pBL = false;
    if (this.pBJ != null)
    {
      this.pBJ.notifyDataSetChanged();
      i = this.pBM;
      this.pBM = (i + 1);
      ad.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.pBN;
    this.pBN = (i + 1);
    ad.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    cgh();
  }
  
  public final void refreshView()
  {
    if (!this.pBL) {
      return;
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */