package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ar;
import java.util.HashMap;

public abstract class a
  extends BaseAdapter
{
  private final String TAG = "MicroMsg.BaseEmojiListAdapter";
  private final String dzu = "lock";
  public AbsListView iVH;
  public c iVI;
  public h.a iVJ;
  protected volatile boolean iVK = false;
  private int iVL = 0;
  private int iVM = 0;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> iVt;
  public Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.iVt = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.iVT == f.a.iWc) {
      return paramf.iVV.bxH + "_cell";
    }
    return paramf.iVU.syc;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a Ak(String paramString)
  {
    if (this.iVt == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.iVt.get(paramString);
  }
  
  public c a(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    return new c(paramf);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.iVI == paramc)) {
      return;
    }
    this.iVI = paramc.aGW();
    notifyDataSetChanged();
  }
  
  public final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {}
    do
    {
      return;
      paramf.setStatus(paramInt);
      paramf = (ar)this.iVI.iVP.get(paramString);
    } while (paramf == null);
    paramf.Fo(paramInt);
  }
  
  public void aGP()
  {
    if (this.iVt != null) {
      this.iVt.clear();
    }
    super.notifyDataSetChanged();
    this.iVK = true;
  }
  
  public abstract int aGQ();
  
  public abstract int aGR();
  
  public abstract int aGS();
  
  public final void aqU()
  {
    if (!this.iVK) {
      return;
    }
    super.notifyDataSetChanged();
  }
  
  public abstract View b(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final void b(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    ai.d(new a.1(this, paramf));
  }
  
  public void bt(String paramString, int paramInt)
  {
    if ((this.iVt == null) || (this.iVI == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.iVI.Al(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.iVI != null) && (((f)localObject).mStatus == -1))
      {
        y.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.iVI.iVR, this.iVI.Ap(paramString), this.iVI.An(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = Ak(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.aGM();
          return;
        }
      }
    }
  }
  
  public final void bu(String paramString, int paramInt)
  {
    if ((this.iVt == null) || (this.iVI == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.iVI.Al(paramString);
      if (localObject != null)
      {
        if ((paramInt >= 0) && (paramInt < 100))
        {
          a((f)localObject, paramString, 6);
          ((f)localObject).xL = paramInt;
        }
        if (paramInt >= 100) {
          a((f)localObject, paramString, 7);
        }
      }
      com.tencent.mm.plugin.emoji.a.a locala = Ak(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.aGM();
          return;
        }
      }
    }
  }
  
  public abstract com.tencent.mm.plugin.emoji.a.a c(Context paramContext, View paramView);
  
  public void clear()
  {
    if (this.iVt != null)
    {
      this.iVt.clear();
      this.iVt = null;
    }
    if (this.iVI != null)
    {
      this.iVI.clear();
      this.iVI = null;
    }
    this.iVK = false;
  }
  
  public int getCount()
  {
    if (this.iVI == null) {
      return 0;
    }
    return this.iVI.size();
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
    f localf = pP(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = c(this.mContext, paramView);
      localView = locala2.aGN();
      this.iVt.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.iUv = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.aGM();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!bk.bl(a(localf)))
      {
        if (this.iVt.containsValue(locala1)) {
          this.iVt.remove(locala1.getProductId());
        }
        this.iVt.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.iVK = false;
    if (this.iVI != null)
    {
      this.iVI.notifyDataSetChanged();
      i = this.iVL;
      this.iVL = (i + 1);
      y.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.iVM;
    this.iVM = (i + 1);
    y.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    aGP();
  }
  
  public abstract void pM(int paramInt);
  
  public abstract void pN(int paramInt);
  
  public abstract void pO(int paramInt);
  
  public f pP(int paramInt)
  {
    if (this.iVI == null) {
      return null;
    }
    return this.iVI.pT(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */