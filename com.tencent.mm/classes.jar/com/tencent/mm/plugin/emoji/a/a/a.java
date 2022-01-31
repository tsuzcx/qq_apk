package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public abstract class a
  extends BaseAdapter
{
  private final String TAG = "MicroMsg.BaseEmojiListAdapter";
  private final String esj = "lock";
  public AbsListView leN;
  public c leO;
  public h.a leP;
  protected volatile boolean leQ = false;
  private int leR = 0;
  private int leS = 0;
  private HashMap<String, com.tencent.mm.plugin.emoji.a.a> ley;
  protected Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.ley = new HashMap();
    }
  }
  
  public static String a(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.leZ == f.a.lfi) {
      return paramf.lfb.ID + "_cell";
    }
    return paramf.lfa.ProductID;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a Ki(String paramString)
  {
    if (this.ley == null) {
      return null;
    }
    return (com.tencent.mm.plugin.emoji.a.a)this.ley.get(paramString);
  }
  
  protected c a(e parame)
  {
    return new c(parame);
  }
  
  public final void a(c paramc)
  {
    if ((paramc == null) || (this.leO == paramc)) {
      return;
    }
    this.leO = paramc.bkI();
    notifyDataSetChanged();
  }
  
  protected final void a(f paramf, String paramString, int paramInt)
  {
    if ((paramf == null) || (paramString == null)) {
      return;
    }
    paramf.setStatus(paramInt);
    this.leO.bZ(paramString, paramInt);
  }
  
  public abstract View b(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final void b(e parame)
  {
    al.d(new a.1(this, parame));
  }
  
  public void bX(String paramString, int paramInt)
  {
    if ((this.ley == null) || (this.leO == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.leO.Kj(paramString);
      if (localObject != null) {
        a((f)localObject, paramString, paramInt);
      }
      if ((localObject != null) && (this.leO != null) && (((f)localObject).mStatus == -1))
      {
        ab.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
        ((f)localObject).a(this.leO.leX, this.leO.Kn(paramString), this.leO.Kl(paramString));
      }
      com.tencent.mm.plugin.emoji.a.a locala = Ki(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.bky();
          return;
        }
      }
    }
  }
  
  public final void bY(String paramString, int paramInt)
  {
    if ((this.ley == null) || (this.leO == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.leO.Kj(paramString);
      if (localObject != null)
      {
        if ((paramInt >= 0) && (paramInt < 100))
        {
          a((f)localObject, paramString, 6);
          ((f)localObject).ym = paramInt;
        }
        if (paramInt >= 100) {
          a((f)localObject, paramString, 7);
        }
      }
      com.tencent.mm.plugin.emoji.a.a locala = Ki(paramString);
      if (locala != null)
      {
        if (locala.getProductId() == null) {}
        for (localObject = null; (localObject != null) && (((String)localObject).equals(paramString)); localObject = locala.getProductId())
        {
          locala.bky();
          return;
        }
      }
    }
  }
  
  protected void bkB()
  {
    if (this.ley != null) {
      this.ley.clear();
    }
    super.notifyDataSetChanged();
    this.leQ = true;
  }
  
  public abstract int bkC();
  
  public abstract int bkD();
  
  public abstract int bkE();
  
  public void clear()
  {
    if (this.ley != null)
    {
      this.ley.clear();
      this.ley = null;
    }
    if (this.leO != null)
    {
      this.leO.clear();
      this.leO = null;
    }
    this.leQ = false;
  }
  
  protected abstract com.tencent.mm.plugin.emoji.a.a d(Context paramContext, View paramView);
  
  public int getCount()
  {
    if (this.leO == null) {
      return 0;
    }
    return this.leO.size();
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
    f localf = uj(paramInt);
    com.tencent.mm.plugin.emoji.a.a locala2;
    View localView;
    if (locala1 == null)
    {
      locala2 = d(this.mContext, paramView);
      localView = locala2.bkz();
      this.ley.put(a(localf), locala2);
    }
    for (;;)
    {
      locala2.mPosition = paramInt;
      locala2.ldz = localf;
      paramView = b(paramInt, localView, paramViewGroup);
      locala2.bky();
      return paramView;
      locala2 = locala1;
      localView = paramView;
      if (!bo.isNullOrNil(a(localf)))
      {
        if (this.ley.containsValue(locala1)) {
          this.ley.remove(locala1.getProductId());
        }
        this.ley.put(a(localf), locala1);
        locala2 = locala1;
        localView = paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.leQ = false;
    if (this.leO != null)
    {
      this.leO.notifyDataSetChanged();
      i = this.leR;
      this.leR = (i + 1);
      ab.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", new Object[] { Integer.valueOf(i) });
    }
    int i = this.leS;
    this.leS = (i + 1);
    ab.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", new Object[] { Integer.valueOf(i) });
    bkB();
  }
  
  public final void refreshView()
  {
    if (!this.leQ) {
      return;
    }
    super.notifyDataSetChanged();
  }
  
  public abstract void ug(int paramInt);
  
  public abstract void uh(int paramInt);
  
  public abstract void ui(int paramInt);
  
  public f uj(int paramInt)
  {
    if (this.leO == null) {
      return null;
    }
    return this.leO.un(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */