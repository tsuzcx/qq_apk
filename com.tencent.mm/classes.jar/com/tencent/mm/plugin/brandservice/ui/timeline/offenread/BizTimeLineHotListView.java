package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotListView
  extends MRecyclerView
{
  private List<b> iQp;
  private f jYY;
  private a jYZ;
  private e jZa;
  private float jvC;
  private int jvD;
  private Context mContext;
  private int mScreenWidth;
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(14290);
    this.iQp = new ArrayList();
    this.jvC = 0.0F;
    this.mScreenWidth = 0;
    this.jvD = 0;
    this.mContext = paramContext;
    AppMethodBeat.o(14290);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(14291);
    this.iQp = new ArrayList();
    this.jvC = 0.0F;
    this.mScreenWidth = 0;
    this.jvD = 0;
    this.mContext = paramContext;
    AppMethodBeat.o(14291);
  }
  
  private void aO(List<b> paramList)
  {
    AppMethodBeat.i(14301);
    if (this.iQp == null)
    {
      AppMethodBeat.o(14301);
      return;
    }
    b localb = new b((byte)0);
    localb.wqR = "__BizTimeLine.CustomItem__";
    paramList.add(0, localb);
    AppMethodBeat.o(14301);
  }
  
  private void g(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(14295);
    ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramv != null)
    {
      float f = paramv.aku.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramv.aku.setAlpha(0.3F);
        AppMethodBeat.o(14295);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.jvC))
      {
        f = 1.0F - (f - this.jvC) / this.jvD * 0.7F;
        ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramv.aku.setAlpha(f);
        AppMethodBeat.o(14295);
        return;
      }
      paramv.aku.setAlpha(1.0F);
    }
    AppMethodBeat.o(14295);
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(14297);
    int i = a.jdMethod_do(getContext());
    AppMethodBeat.o(14297);
    return i;
  }
  
  public final void a(Context paramContext, List<b> paramList, e parame)
  {
    AppMethodBeat.i(14294);
    this.jZa = parame;
    this.iQp.addAll(paramList);
    aO(this.iQp);
    this.jYZ = new a(paramContext);
    paramList = new BizTimeLineHotListView.2(this);
    paramList.setOrientation(0);
    setLayoutManager(paramList);
    setAdapter(this.jYZ);
    this.jYY = new f(getCustomItemCount());
    paramList = this.jYY;
    int i = a.getCompletelyCountPerPage();
    paramList.mContext = paramContext;
    paramList.jZy = this;
    paramList.jvU = i;
    paramList.jZy.b(paramList);
    paramList.jZy.a(paramList);
    paramList.jvX = ((LinearLayoutManager)paramList.jZy.getLayoutManager());
    paramList.ajo = new f.1(paramList, paramList.jZy.getContext());
    paramList.jvT = new f.2(paramList, paramList.jZy.getContext());
    setOnScrollPageListener(new f.a()
    {
      public final void fM(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(14283);
        if (!paramAnonymousBoolean)
        {
          int i = (int)(System.currentTimeMillis() / 1000L);
          h.qsU.e(15721, new Object[] { "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.storage.s.getSessionId()) });
        }
        BizTimeLineHotListView.this.aWZ();
        AppMethodBeat.o(14283);
      }
      
      public final void sh(int paramAnonymousInt)
      {
        AppMethodBeat.i(14282);
        ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(BizTimeLineHotListView.this.getCurrentPage()) });
        BizTimeLineHotListView.d(BizTimeLineHotListView.this);
        AppMethodBeat.o(14282);
      }
    });
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void N(View paramAnonymousView, int paramAnonymousInt)
      {
        int j = 0;
        int i = 0;
        AppMethodBeat.i(14281);
        paramAnonymousView = (b)BizTimeLineHotListView.b(BizTimeLineHotListView.this).get(paramAnonymousInt);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(14281);
          return;
        }
        Object localObject1 = BizTimeLineHotListView.a(BizTimeLineHotListView.this);
        Object localObject2;
        if (paramAnonymousView != null)
        {
          localObject2 = ((e)localObject1).jZw.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            bha localbha = (bha)((Iterator)localObject2).next();
            if (bo.isEqual(localbha.wyW, paramAnonymousView.wqR))
            {
              localbha.xwf = ((int)(System.currentTimeMillis() / 1000L));
              paramAnonymousInt = i;
              if (paramAnonymousView.jZt) {
                paramAnonymousInt = 1;
              }
              localbha.xwe = paramAnonymousInt;
            }
          }
        }
        for (;;)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Chat_User", paramAnonymousView.wqR);
          ((Intent)localObject1).putExtra("finish_direct", true);
          ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 91);
          ((Intent)localObject1).putExtra("specific_chat_from_scene", 8);
          ((Intent)localObject1).putExtra("preChatTYPE", 12);
          d.f(BizTimeLineHotListView.c(BizTimeLineHotListView.this), ".ui.chatting.ChattingUI", (Intent)localObject1);
          AppMethodBeat.o(14281);
          return;
          localObject2 = new bha();
          ((bha)localObject2).wyW = paramAnonymousView.wqR;
          ((bha)localObject2).nox = (paramAnonymousView.position - 1);
          ((bha)localObject2).xwf = ((int)(System.currentTimeMillis() / 1000L));
          paramAnonymousInt = j;
          if (paramAnonymousView.jZt) {
            paramAnonymousInt = 1;
          }
          ((bha)localObject2).xwe = paramAnonymousInt;
          ((e)localObject1).jZw.add(localObject2);
        }
      }
    });
    AppMethodBeat.o(14294);
  }
  
  public final boolean aSn()
  {
    return false;
  }
  
  public final void aW(List<b> paramList)
  {
    AppMethodBeat.i(14292);
    this.iQp.clear();
    this.iQp.addAll(paramList);
    aO(this.iQp);
    this.jYZ.ajb.notifyChanged();
    AppMethodBeat.o(14292);
  }
  
  public final void aWZ()
  {
    AppMethodBeat.i(14293);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.iQp);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new BizTimeLineHotListView.1(this, localArrayList), 0L);
    AppMethodBeat.o(14293);
  }
  
  public final boolean ag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14296);
    f localf = this.jYY;
    localf.N(localf.qR(localf.mOffsetX + paramInt1), false);
    boolean bool = super.ag(paramInt1, paramInt2);
    AppMethodBeat.o(14296);
    return bool;
  }
  
  public a getAdapter()
  {
    return this.jYZ;
  }
  
  public int getCurrentPage()
  {
    if (this.jYY != null) {
      return this.jYY.jpR;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 1;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(14298);
    int i = this.iQp.size();
    AppMethodBeat.o(14298);
    return i;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(14300);
    int i = a.dn(this.mContext);
    AppMethodBeat.o(14300);
    return i;
  }
  
  public int getShowCount()
  {
    return 12;
  }
  
  protected float getShowCountPerPage()
  {
    AppMethodBeat.i(14299);
    float f = a.getShowCountPerPage();
    AppMethodBeat.o(14299);
    return f;
  }
  
  public void setOnScrollPageListener(f.a parama)
  {
    if (this.jYY != null) {
      this.jYY.jZA = parama;
    }
  }
  
  public final class a
    extends RecyclerView.a<BizTimeLineHotListView.b>
  {
    private Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private void a(BizTimeLineHotListView.b paramb, b paramb1, int paramInt)
    {
      AppMethodBeat.i(14286);
      int j = BizTimeLineHotListView.this.getItemWidth();
      float f = BizTimeLineHotListView.this.getShowCountPerPage();
      int i = j;
      if (j <= 0) {
        i = (int)(BizTimeLineHotListView.this.getWidth() / f);
      }
      j = i;
      if (i <= 0) {
        j = (int)(BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / f);
      }
      i = j;
      if (paramInt == BizTimeLineHotListView.e(BizTimeLineHotListView.this).getItemCount() - 1)
      {
        double d = j;
        i = (int)((1.0D - (Math.ceil(f) - f)) * d);
        ab.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      }
      paramb.aku.getLayoutParams().width = i;
      paramb.aku.setScaleX(1.0F);
      paramb.aku.setScaleY(1.0F);
      paramb.titleTv.setText("pos:".concat(String.valueOf(paramInt)));
      ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((paramb1 != null) && (paramb1.type != 2))
      {
        a.b.s(paramb.ivs, paramb1.wqR);
        String str = com.tencent.mm.model.s.nE(paramb1.wqR);
        paramb.titleTv.setText(str);
        if (!paramb1.jZt) {
          break label288;
        }
        paramb.jZd.setVisibility(0);
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, paramb1, paramInt);
        AppMethodBeat.o(14286);
        return;
        label288:
        paramb.jZd.setVisibility(8);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(14284);
      if (bo.es(BizTimeLineHotListView.b(BizTimeLineHotListView.this)))
      {
        AppMethodBeat.o(14284);
        return 0;
      }
      int j = BizTimeLineHotListView.b(BizTimeLineHotListView.this).size();
      int k = a.getCompletelyCountPerPage();
      int i = j;
      if (BizTimeLineHotListView.this.getCustomItemCount() == 1) {
        i = j - 1;
      }
      j = i;
      if (i > BizTimeLineHotListView.this.getShowCount()) {
        j = BizTimeLineHotListView.this.getShowCount();
      }
      if (BizTimeLineHotListView.this.getCustomItemCount() == 1)
      {
        if (j % k == 0) {}
        for (i = j + 1;; i = j + (k + 1 - j % k))
        {
          j = BizTimeLineHotListView.this.getCustomItemCount();
          AppMethodBeat.o(14284);
          return i + j;
        }
      }
      i = j;
      if (j % k != 0) {
        i = j + (k - j % k);
      }
      AppMethodBeat.o(14284);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(14285);
      paramInt = super.getItemViewType(paramInt);
      AppMethodBeat.o(14285);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */