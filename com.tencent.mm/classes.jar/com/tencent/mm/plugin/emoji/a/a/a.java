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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public abstract class a
  extends BaseAdapter
{
  private final String TAG = "MicroMsg.BaseEmojiListAdapter";
  private final String gfA = "lock";
  protected Context mContext;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> pHX;
  public AbsListView pIm;
  public c pIn;
  public j.a pIo;
  protected volatile boolean pIp = false;
  private int pIq = 0;
  private int pIr = 0;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.pHX = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.pIy == f.a.pIH) {
      return paramf.pIA.ID + "_cell";
    }
    return paramf.pIz.ProductID;
  }
  
  public abstract void Cb(int paramInt);
  
  public abstract void Cc(int paramInt);
  
  public abstract void Cd(int paramInt);
  
  public f Ce(int paramInt)
  {
    if (this.pIn == null) {
      return null;
    }
    return this.pIn.Cj(paramInt);
  }
  
  protected c a(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    return new c(paramf);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.pIn == paramc)) {
      return;
    }
    this.pIn = paramc.chD();
    notifyDataSetChanged();
  }
  
  protected final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {
      return;
    }
    paramf.setStatus(paramInt);
    this.pIn.cY(paramString, paramInt);
  }
  
  public final com.tencent.mm.plugin.emoji.a.a abY(String paramString)
  {
    if (this.pHX == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.pHX.get(paramString);
  }
  
  public abstract View b(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final void b(final com.tencent.mm.plugin.emoji.model.f paramf)
  {
    ar.f(new Runnable()
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
  
  public void cW(String paramString, int paramInt)
  {
    if ((this.pHX == null) || (this.pIn == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.pIn.abZ(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.pIn != null) && (((f)localObject).mStatus == -1))
      {
        ae.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.pIn.pIw, this.pIn.acd(paramString), this.pIn.acb(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = abY(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.chv();
          return;
        }
      }
    }
  }
  
  public final void cX(String paramString, int paramInt)
  {
    if ((this.pHX == null) || (this.pIn == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.pIn.abZ(paramString);
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
      com.tencent.mm.plugin.emoji.a.a locala = abY(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.chv();
          return;
        }
      }
    }
  }
  
  public abstract int chA();
  
  protected void chx()
  {
    if (this.pHX != null) {
      this.pHX.clear();
    }
    super.notifyDataSetChanged();
    this.pIp = true;
  }
  
  public abstract int chy();
  
  public abstract int chz();
  
  public void clear()
  {
    if (this.pHX != null)
    {
      this.pHX.clear();
      this.pHX = null;
    }
    if (this.pIn != null)
    {
      this.pIn.clear();
      this.pIn = null;
    }
    this.pIp = false;
  }
  
  protected abstract com.tencent.mm.plugin.emoji.a.a d(Context paramContext, View paramView);
  
  public int getCount()
  {
    if (this.pIn == null) {
      return 0;
    }
    return this.pIn.size();
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
    f localf = Ce(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = d(this.mContext, paramView);
      localView = locala2.getRoot();
      this.pHX.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.pGY = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.chv();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!bu.isNullOrNil(a(localf)))
      {
        if (this.pHX.containsValue(locala1)) {
          this.pHX.remove(locala1.getProductId());
        }
        this.pHX.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.pIp = false;
    if (this.pIn != null)
    {
      this.pIn.notifyDataSetChanged();
      i = this.pIq;
      this.pIq = (i + 1);
      ae.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.pIr;
    this.pIr = (i + 1);
    ae.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    chx();
  }
  
  public final void refreshView()
  {
    if (!this.pIp) {
      return;
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */