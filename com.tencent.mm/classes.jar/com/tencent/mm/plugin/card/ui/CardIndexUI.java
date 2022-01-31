package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CardIndexUI
  extends CardBaseUI
{
  private final String TAG = "MicroMsg.CardIndexUI";
  int fromScene = 0;
  private View kwh;
  private TextView kwi;
  private f kwj;
  private TextView kwk;
  private TextView kwl;
  private ImageView kwm;
  private LinearLayout kwn;
  int kwo = -1;
  private long mStartTime = 0L;
  
  private void bd(List<byk> paramList)
  {
    AppMethodBeat.i(88528);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        byk localbyk = (byk)paramList.next();
        if (localbyk.wFs == 1)
        {
          ab.i("MicroMsg.CardIndexUI", "should update new invoice");
          be(localbyk.xKL);
        }
      }
    }
    beh();
    AppMethodBeat.o(88528);
  }
  
  private void be(List<oy> paramList)
  {
    AppMethodBeat.i(88529);
    this.kkI.removeAllViews();
    this.kkI.setPadding(0, 0, 0, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (oy)paramList.next();
        View localView = View.inflate(getContext(), 2130968961, null);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131822261);
        TextView localTextView1 = (TextView)localView.findViewById(2131822262);
        TextView localTextView2 = (TextView)localView.findViewById(2131822263);
        localCdnImageView.setUrl(((oy)localObject).wFF);
        localTextView1.setText(((oy)localObject).wFE);
        localTextView2.setText(((oy)localObject).wFG);
        if (((oy)localObject).wFH > 0) {
          localView.setOnClickListener(new CardIndexUI.2(this, (oy)localObject));
        }
        this.kkI.addView(localView);
        if (i == 0) {
          this.kkI.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this, 13), 0, 0);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 6);
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(88529);
  }
  
  private void beh()
  {
    AppMethodBeat.i(88527);
    if ((this.kkI.getChildCount() == 0) && (this.kkG.getCount() == 0))
    {
      ab.i("MicroMsg.CardIndexUI", "show empty view");
      this.kkH.setVisibility(0);
      this.kkF.setVisibility(8);
      AppMethodBeat.o(88527);
      return;
    }
    ab.i("MicroMsg.CardIndexUI", "hide empty view");
    this.kkH.setVisibility(8);
    this.kkF.setVisibility(0);
    AppMethodBeat.o(88527);
  }
  
  public final BaseAdapter Kp()
  {
    AppMethodBeat.i(88533);
    if (3 == this.kwo)
    {
      localObject = new k(this, bay());
      AppMethodBeat.o(88533);
      return localObject;
    }
    Object localObject = new c(this, bay());
    AppMethodBeat.o(88533);
    return localObject;
  }
  
  public final void bax()
  {
    AppMethodBeat.i(88526);
    Object localObject;
    if (1 == this.kwo)
    {
      setMMTitle(2131297987);
      this.kwk = ((TextView)findViewById(2131821982));
      this.kwl = ((TextView)findViewById(2131822248));
      this.kwm = ((ImageView)findViewById(2131822246));
      this.kwh = findViewById(2131822249);
      this.kwi = ((TextView)findViewById(2131822251));
      this.kwn = ((LinearLayout)findViewById(2131822247));
      this.kwh.setVisibility(8);
      this.kwl.setVisibility(0);
      this.kwk.setVisibility(0);
      this.kwm.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.kwn.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.b.b(this, 100.0F);
      this.kwn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.kwo) {
        break label363;
      }
      this.kwl.setText(getString(2131297975));
      this.kwk.setText(getString(2131297974));
    }
    for (;;)
    {
      if (this.kwo == 3)
      {
        this.kkF.setEmptyView(null);
        this.kkH.setVisibility(8);
      }
      this.kwi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(88521);
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).knB)) {
            com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).knB, 0);
          }
          AppMethodBeat.o(88521);
        }
      });
      if ((this.kwo != 3) || (!((Boolean)g.RL().Ru().get(ac.a.yzp, Boolean.FALSE)).booleanValue())) {
        break label447;
      }
      ab.i("MicroMsg.CardIndexUI", "has load new entrance");
      localObject = (String)g.RL().Ru().get(ac.a.yzn, null);
      if (bo.isNullOrNil((String)localObject)) {
        break label447;
      }
      try
      {
        byl localbyl = new byl();
        localbyl.parseFrom(((String)localObject).getBytes("ISO-8859-1"));
        bd(localbyl.xKM);
        AppMethodBeat.o(88526);
        return;
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.kwo)
      {
        setMMTitle(2131298079);
        break;
      }
      setMMTitle(2131297997);
      break;
      label363:
      if (3 == this.kwo)
      {
        this.kwl.setText(getString(2131297981));
        this.kwk.setText(getString(2131297980));
      }
      else
      {
        this.kwl.setText(getString(2131298018));
        this.kwk.setText(getString(2131298033));
      }
    }
    label447:
    AppMethodBeat.o(88526);
  }
  
  public final n.a bay()
  {
    AppMethodBeat.i(88532);
    if (1 == this.kwo)
    {
      locala = n.a.koe;
      AppMethodBeat.o(88532);
      return locala;
    }
    if (3 == this.kwo)
    {
      if (((Boolean)g.RL().Ru().get(ac.a.yzp, Boolean.FALSE)).booleanValue())
      {
        locala = n.a.kog;
        AppMethodBeat.o(88532);
        return locala;
      }
      locala = n.a.kod;
      AppMethodBeat.o(88532);
      return locala;
    }
    n.a locala = n.a.koa;
    AppMethodBeat.o(88532);
    return locala;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88525);
    if (getIntent() != null) {
      this.kwo = getIntent().getIntExtra("key_card_type", -1);
    }
    super.initView();
    AppMethodBeat.o(88525);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(88535);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(88535);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88523);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.CardIndexUI", "oncreate");
    this.mStartTime = System.currentTimeMillis();
    initView();
    g.RK().eHt.a(984, this);
    am.bcc();
    com.tencent.mm.plugin.card.b.b.sW(1);
    int i = am.bch().kme;
    if ((com.tencent.mm.x.c.PJ().cc(262152, 266256)) || (i > 0))
    {
      h.qsU.e(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      AppMethodBeat.o(88523);
      return;
    }
    h.qsU.e(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(88523);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88524);
    g.RK().eHt.b(984, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    h.qsU.e(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
    AppMethodBeat.o(88524);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(88530);
    super.onResume();
    AppMethodBeat.o(88530);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(88534);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof x))
      {
        this.kwj = i.Iz((String)g.RL().Ru().get(282885, ""));
        if (this.kwj == null) {
          this.kwj = new f();
        }
        if ((this.kwj != null) && (!TextUtils.isEmpty(this.kwj.knz))) {
          this.kwk.setText(this.kwj.knz);
        }
        if ((this.kwj == null) || (!this.kwj.knC))
        {
          this.kwh.setVisibility(8);
          AppMethodBeat.o(88534);
          return;
        }
        this.kwi.setText(this.kwj.knA);
        if ((!TextUtils.isEmpty(this.kwj.knA)) && (!TextUtils.isEmpty(this.kwj.knB)))
        {
          this.kwh.setVisibility(0);
          AppMethodBeat.o(88534);
          return;
        }
        this.kwh.setVisibility(8);
        AppMethodBeat.o(88534);
        return;
      }
      if ((paramm instanceof ad))
      {
        paramString = (ad)paramm;
        if ((paramString.koy) && ((this.kkG instanceof c)))
        {
          ((c)this.kkG).qp(false);
          ((c)this.kkG).qp(true);
          ((c)this.kkG).Ku();
        }
        if ((((Boolean)g.RL().Ru().get(ac.a.yzp, Boolean.FALSE)).booleanValue()) && (paramString.koA != null))
        {
          bd(paramString.koA.xKM);
          if ((this.kkG instanceof c))
          {
            ((c)this.kkG).qp(false);
            ((c)this.kkG).qp(true);
            ((c)this.kkG).Ku();
          }
        }
      }
    }
    AppMethodBeat.o(88534);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(88531);
    super.onStop();
    AppMethodBeat.o(88531);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI
 * JD-Core Version:    0.7.0.1
 */