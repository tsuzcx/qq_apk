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
  private final String fGk = "lock";
  protected Context mContext;
  public j.a ouA;
  protected volatile boolean ouB = false;
  private int ouC = 0;
  private int ouD = 0;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> oui;
  public AbsListView ouy;
  public c ouz;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.oui = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.ouK == f.a.ouT) {
      return paramf.ouM.ID + "_cell";
    }
    return paramf.ouL.ProductID;
  }
  
  public abstract void Ap(int paramInt);
  
  public abstract void Aq(int paramInt);
  
  public abstract void Ar(int paramInt);
  
  public f As(int paramInt)
  {
    if (this.ouz == null) {
      return null;
    }
    return this.ouz.Ax(paramInt);
  }
  
  public final com.tencent.mm.plugin.emoji.a.a To(String paramString)
  {
    if (this.oui == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.oui.get(paramString);
  }
  
  protected c a(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    return new c(paramf);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.ouz == paramc)) {
      return;
    }
    this.ouz = paramc.bUw();
    notifyDataSetChanged();
  }
  
  protected final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {
      return;
    }
    paramf.setStatus(paramInt);
    this.ouz.cM(paramString, paramInt);
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
  
  protected void bUq()
  {
    if (this.oui != null) {
      this.oui.clear();
    }
    super.notifyDataSetChanged();
    this.ouB = true;
  }
  
  public abstract int bUr();
  
  public abstract int bUs();
  
  public abstract int bUt();
  
  public void cK(String paramString, int paramInt)
  {
    if ((this.oui == null) || (this.ouz == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.ouz.Tp(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.ouz != null) && (((f)localObject).mStatus == -1))
      {
        ad.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.ouz.ouI, this.ouz.Tt(paramString), this.ouz.Tr(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = To(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.bUn();
          return;
        }
      }
    }
  }
  
  public final void cL(String paramString, int paramInt)
  {
    if ((this.oui == null) || (this.ouz == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.ouz.Tp(paramString);
      if (localObject != null)
      {
        if ((paramInt >= 0) && (paramInt < 100))
        {
          a((f)localObject, paramString, 6);
          ((f)localObject).EI = paramInt;
        }
        if (paramInt >= 100) {
          a((f)localObject, paramString, 7);
        }
      }
      com.tencent.mm.plugin.emoji.a.a locala = To(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.bUn();
          return;
        }
      }
    }
  }
  
  public void clear()
  {
    if (this.oui != null)
    {
      this.oui.clear();
      this.oui = null;
    }
    if (this.ouz != null)
    {
      this.ouz.clear();
      this.ouz = null;
    }
    this.ouB = false;
  }
  
  protected abstract com.tencent.mm.plugin.emoji.a.a d(Context paramContext, View paramView);
  
  public int getCount()
  {
    if (this.ouz == null) {
      return 0;
    }
    return this.ouz.size();
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
    f localf = As(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = d(this.mContext, paramView);
      localView = locala2.getRoot();
      this.oui.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.otj = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.bUn();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!bt.isNullOrNil(a(localf)))
      {
        if (this.oui.containsValue(locala1)) {
          this.oui.remove(locala1.getProductId());
        }
        this.oui.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.ouB = false;
    if (this.ouz != null)
    {
      this.ouz.notifyDataSetChanged();
      i = this.ouC;
      this.ouC = (i + 1);
      ad.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.ouD;
    this.ouD = (i + 1);
    ad.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    bUq();
  }
  
  public final void refreshView()
  {
    if (!this.ouB) {
      return;
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */