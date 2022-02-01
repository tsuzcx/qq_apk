package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.c.i;
import com.tencent.mm.plugin.card.mgr.j;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ewo;
import com.tencent.mm.protocal.protobuf.ewp;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CardIndexUI
  extends CardBaseUI
{
  private final String TAG = "MicroMsg.CardIndexUI";
  int fromScene = 0;
  private long mStartTime = 0L;
  int viewType = -1;
  private View wCF;
  private TextView wCG;
  private com.tencent.mm.plugin.card.model.f wCH;
  private TextView wCI;
  private TextView wCJ;
  private ImageView wCK;
  private LinearLayout wCL;
  
  private void dmU()
  {
    AppMethodBeat.i(113454);
    if ((this.wqT.getChildCount() == 0) && (this.wqR.getCount() == 0))
    {
      Log.i("MicroMsg.CardIndexUI", "show empty view");
      this.wqS.setVisibility(0);
      this.wqQ.setVisibility(8);
      AppMethodBeat.o(113454);
      return;
    }
    Log.i("MicroMsg.CardIndexUI", "hide empty view");
    this.wqS.setVisibility(8);
    this.wqQ.setVisibility(0);
    AppMethodBeat.o(113454);
  }
  
  private void eL(List<ewo> paramList)
  {
    AppMethodBeat.i(113455);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ewo localewo = (ewo)paramList.next();
        if (localewo.Zdd == 1)
        {
          Log.i("MicroMsg.CardIndexUI", "should update new invoice");
          eM(localewo.abyP);
        }
      }
    }
    dmU();
    AppMethodBeat.o(113455);
  }
  
  private void eM(List<wk> paramList)
  {
    AppMethodBeat.i(113456);
    this.wqT.removeAllViews();
    this.wqT.setPadding(0, 0, 0, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (wk)paramList.next();
        View localView = View.inflate(getContext(), a.e.wni, null);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(a.d.wjn);
        TextView localTextView1 = (TextView)localView.findViewById(a.d.wjp);
        TextView localTextView2 = (TextView)localView.findViewById(a.d.wjm);
        localCdnImageView.setUrl(((wk)localObject).Zdq);
        localTextView1.setText(((wk)localObject).Zdp);
        localTextView2.setText(((wk)localObject).Zdr);
        if (((wk)localObject).Zds > 0) {
          localView.setOnClickListener(new CardIndexUI.2(this, (wk)localObject));
        }
        this.wqT.addView(localView);
        if (i == 0) {
          this.wqT.setPadding(0, com.tencent.mm.cd.a.fromDPToPix(this, 13), 0, 0);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 6);
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(113456);
  }
  
  public final BaseAdapter aNu()
  {
    AppMethodBeat.i(113460);
    if (3 == this.viewType)
    {
      localObject = new k(this, djc());
      AppMethodBeat.o(113460);
      return localObject;
    }
    Object localObject = new c(this, djc());
    AppMethodBeat.o(113460);
    return localObject;
  }
  
  public final void djb()
  {
    AppMethodBeat.i(113453);
    Object localObject;
    if (1 == this.viewType)
    {
      setMMTitle(a.g.wpv);
      this.wCI = ((TextView)findViewById(a.d.wkG));
      this.wCJ = ((TextView)findViewById(a.d.wkH));
      this.wCK = ((ImageView)findViewById(a.d.wkE));
      this.wCF = findViewById(a.d.wgi);
      this.wCG = ((TextView)findViewById(a.d.wgj));
      this.wCL = ((LinearLayout)findViewById(a.d.wkF));
      this.wCF.setVisibility(8);
      this.wCJ.setVisibility(0);
      this.wCI.setVisibility(0);
      this.wCK.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.wCL.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 100.0F);
      this.wCL.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.viewType) {
        break label367;
      }
      this.wCJ.setText(getString(a.g.wpk));
      this.wCI.setText(getString(a.g.wpj));
    }
    for (;;)
    {
      if (this.viewType == 3)
      {
        this.wqQ.setEmptyView(null);
        this.wqS.setVisibility(8);
      }
      this.wCG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113448);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).wtS)) {
            com.tencent.mm.plugin.card.c.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).wtS, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113448);
        }
      });
      if ((this.viewType != 3) || (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJJ, Boolean.FALSE)).booleanValue())) {
        break label451;
      }
      Log.i("MicroMsg.CardIndexUI", "has load new entrance");
      localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJH, null);
      if (Util.isNullOrNil((String)localObject)) {
        break label451;
      }
      try
      {
        ewp localewp = new ewp();
        localewp.parseFrom(((String)localObject).getBytes("ISO-8859-1"));
        eL(localewp.abyQ);
        AppMethodBeat.o(113453);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.viewType)
      {
        setMMTitle(a.g.wqE);
        break;
      }
      setMMTitle(a.g.wpE);
      break;
      label367:
      if (3 == this.viewType)
      {
        this.wCJ.setText(getString(a.g.wpp));
        this.wCI.setText(getString(a.g.wpo));
      }
      else
      {
        this.wCJ.setText(getString(a.g.wpO));
        this.wCI.setText(getString(a.g.wpW));
      }
    }
    label451:
    AppMethodBeat.o(113453);
  }
  
  public final n.a djc()
  {
    AppMethodBeat.i(113459);
    if (1 == this.viewType)
    {
      locala = n.a.wuu;
      AppMethodBeat.o(113459);
      return locala;
    }
    if (3 == this.viewType)
    {
      if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJJ, Boolean.FALSE)).booleanValue())
      {
        locala = n.a.wuw;
        AppMethodBeat.o(113459);
        return locala;
      }
      locala = n.a.wut;
      AppMethodBeat.o(113459);
      return locala;
    }
    n.a locala = n.a.wuq;
    AppMethodBeat.o(113459);
    return locala;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113452);
    if (getIntent() != null) {
      this.viewType = getIntent().getIntExtra("key_card_type", -1);
    }
    super.initView();
    AppMethodBeat.o(113452);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113462);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(113462);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113450);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.CardIndexUI", "oncreate");
    this.mStartTime = System.currentTimeMillis();
    initView();
    com.tencent.mm.kernel.h.baD().mCm.a(1054, this);
    am.dkI();
    com.tencent.mm.plugin.card.mgr.a.Ih(1);
    int i = am.dkN().wsr;
    if ((com.tencent.mm.aa.c.aYo().dV(262152, 266256)) || (i > 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      AppMethodBeat.o(113450);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113450);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113451);
    com.tencent.mm.kernel.h.baD().mCm.b(1054, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    com.tencent.mm.plugin.report.service.h.OAn.b(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
    AppMethodBeat.o(113451);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113457);
    super.onResume();
    AppMethodBeat.o(113457);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(113461);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof x))
      {
        this.wCH = i.alt((String)com.tencent.mm.kernel.h.baE().ban().d(282885, ""));
        if (this.wCH == null) {
          this.wCH = new com.tencent.mm.plugin.card.model.f();
        }
        if ((this.wCH != null) && (!TextUtils.isEmpty(this.wCH.wtQ))) {
          this.wCI.setText(this.wCH.wtQ);
        }
        if ((this.wCH == null) || (!this.wCH.wtT))
        {
          this.wCF.setVisibility(8);
          AppMethodBeat.o(113461);
          return;
        }
        this.wCG.setText(this.wCH.wtR);
        if ((!TextUtils.isEmpty(this.wCH.wtR)) && (!TextUtils.isEmpty(this.wCH.wtS)))
        {
          this.wCF.setVisibility(0);
          AppMethodBeat.o(113461);
          return;
        }
        this.wCF.setVisibility(8);
        AppMethodBeat.o(113461);
        return;
      }
      if ((paramp instanceof ad))
      {
        paramString = (ad)paramp;
        if ((paramString.wuN) && ((this.wqR instanceof c)))
        {
          ((c)this.wqR).Lh(false);
          ((c)this.wqR).Lh(true);
          ((c)this.wqR).aNy();
        }
        if ((((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJJ, Boolean.FALSE)).booleanValue()) && (paramString.wuP != null))
        {
          eL(paramString.wuP.abyQ);
          if ((this.wqR instanceof c))
          {
            ((c)this.wqR).Lh(false);
            ((c)this.wqR).Lh(true);
            ((c)this.wqR).aNy();
          }
        }
      }
    }
    AppMethodBeat.o(113461);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(113458);
    super.onStop();
    AppMethodBeat.o(113458);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI
 * JD-Core Version:    0.7.0.1
 */