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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CardIndexUI
  extends CardBaseUI
{
  private final String TAG = "MicroMsg.CardIndexUI";
  int fromScene = 0;
  private long mStartTime = 0L;
  private TextView oOA;
  private ImageView oOB;
  private LinearLayout oOC;
  int oOD = -1;
  private View oOw;
  private TextView oOx;
  private f oOy;
  private TextView oOz;
  
  private void bYl()
  {
    AppMethodBeat.i(113454);
    if ((this.oCK.getChildCount() == 0) && (this.oCI.getCount() == 0))
    {
      ae.i("MicroMsg.CardIndexUI", "show empty view");
      this.oCJ.setVisibility(0);
      this.oCH.setVisibility(8);
      AppMethodBeat.o(113454);
      return;
    }
    ae.i("MicroMsg.CardIndexUI", "hide empty view");
    this.oCJ.setVisibility(8);
    this.oCH.setVisibility(0);
    AppMethodBeat.o(113454);
  }
  
  private void cF(List<czx> paramList)
  {
    AppMethodBeat.i(113455);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        czx localczx = (czx)paramList.next();
        if (localczx.Gjq == 1)
        {
          ae.i("MicroMsg.CardIndexUI", "should update new invoice");
          cG(localczx.HJt);
        }
      }
    }
    bYl();
    AppMethodBeat.o(113455);
  }
  
  private void cG(List<tm> paramList)
  {
    AppMethodBeat.i(113456);
    this.oCK.removeAllViews();
    this.oCK.setPadding(0, 0, 0, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (tm)paramList.next();
        View localView = View.inflate(getContext(), 2131493312, null);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131298358);
        TextView localTextView1 = (TextView)localView.findViewById(2131298359);
        TextView localTextView2 = (TextView)localView.findViewById(2131298357);
        localCdnImageView.setUrl(((tm)localObject).GjD);
        localTextView1.setText(((tm)localObject).GjC);
        localTextView2.setText(((tm)localObject).GjE);
        if (((tm)localObject).GjF > 0) {
          localView.setOnClickListener(new CardIndexUI.2(this, (tm)localObject));
        }
        this.oCK.addView(localView);
        if (i == 0) {
          this.oCK.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this, 13), 0, 0);
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
    AppMethodBeat.o(113456);
  }
  
  public final BaseAdapter Zy()
  {
    AppMethodBeat.i(113460);
    if (3 == this.oOD)
    {
      localObject = new k(this, bUw());
      AppMethodBeat.o(113460);
      return localObject;
    }
    Object localObject = new c(this, bUw());
    AppMethodBeat.o(113460);
    return localObject;
  }
  
  public final void bUv()
  {
    AppMethodBeat.i(113453);
    Object localObject;
    if (1 == this.oOD)
    {
      setMMTitle(2131756929);
      this.oOz = ((TextView)findViewById(2131302872));
      this.oOA = ((TextView)findViewById(2131302873));
      this.oOB = ((ImageView)findViewById(2131302870));
      this.oOw = findViewById(2131297793);
      this.oOx = ((TextView)findViewById(2131297794));
      this.oOC = ((LinearLayout)findViewById(2131302871));
      this.oOw.setVisibility(8);
      this.oOA.setVisibility(0);
      this.oOz.setVisibility(0);
      this.oOB.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.oOC.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.b.h(this, 100.0F);
      this.oOC.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.oOD) {
        break label363;
      }
      this.oOA.setText(getString(2131756917));
      this.oOz.setText(getString(2131756916));
    }
    for (;;)
    {
      if (this.oOD == 3)
      {
        this.oCH.setEmptyView(null);
        this.oCJ.setVisibility(8);
      }
      this.oOx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113448);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).oFL)) {
            com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).oFL, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113448);
        }
      });
      if ((this.oOD != 3) || (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMn, Boolean.FALSE)).booleanValue())) {
        break label447;
      }
      ae.i("MicroMsg.CardIndexUI", "has load new entrance");
      localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMl, null);
      if (bu.isNullOrNil((String)localObject)) {
        break label447;
      }
      try
      {
        czy localczy = new czy();
        localczy.parseFrom(((String)localObject).getBytes("ISO-8859-1"));
        cF(localczy.HJu);
        AppMethodBeat.o(113453);
        return;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.oOD)
      {
        setMMTitle(2131757021);
        break;
      }
      setMMTitle(2131756939);
      break;
      label363:
      if (3 == this.oOD)
      {
        this.oOA.setText(getString(2131756923));
        this.oOz.setText(getString(2131756922));
      }
      else
      {
        this.oOA.setText(getString(2131756960));
        this.oOz.setText(getString(2131756975));
      }
    }
    label447:
    AppMethodBeat.o(113453);
  }
  
  public final n.a bUw()
  {
    AppMethodBeat.i(113459);
    if (1 == this.oOD)
    {
      locala = n.a.oGo;
      AppMethodBeat.o(113459);
      return locala;
    }
    if (3 == this.oOD)
    {
      if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMn, Boolean.FALSE)).booleanValue())
      {
        locala = n.a.oGq;
        AppMethodBeat.o(113459);
        return locala;
      }
      locala = n.a.oGn;
      AppMethodBeat.o(113459);
      return locala;
    }
    n.a locala = n.a.oGk;
    AppMethodBeat.o(113459);
    return locala;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113452);
    if (getIntent() != null) {
      this.oOD = getIntent().getIntExtra("key_card_type", -1);
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
    ae.i("MicroMsg.CardIndexUI", "oncreate");
    this.mStartTime = System.currentTimeMillis();
    initView();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1054, this);
    am.bWb();
    com.tencent.mm.plugin.card.b.b.AA(1);
    int i = am.bWg().oEh;
    if ((com.tencent.mm.y.c.ahI().cI(262152, 266256)) || (i > 0))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      AppMethodBeat.o(113450);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113450);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113451);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1054, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    com.tencent.mm.plugin.report.service.g.yxI.f(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
    AppMethodBeat.o(113451);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113457);
    super.onResume();
    AppMethodBeat.o(113457);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113461);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof x))
      {
        this.oOy = i.ZW((String)com.tencent.mm.kernel.g.ajR().ajA().get(282885, ""));
        if (this.oOy == null) {
          this.oOy = new f();
        }
        if ((this.oOy != null) && (!TextUtils.isEmpty(this.oOy.oFJ))) {
          this.oOz.setText(this.oOy.oFJ);
        }
        if ((this.oOy == null) || (!this.oOy.oFM))
        {
          this.oOw.setVisibility(8);
          AppMethodBeat.o(113461);
          return;
        }
        this.oOx.setText(this.oOy.oFK);
        if ((!TextUtils.isEmpty(this.oOy.oFK)) && (!TextUtils.isEmpty(this.oOy.oFL)))
        {
          this.oOw.setVisibility(0);
          AppMethodBeat.o(113461);
          return;
        }
        this.oOw.setVisibility(8);
        AppMethodBeat.o(113461);
        return;
      }
      if ((paramn instanceof ad))
      {
        paramString = (ad)paramn;
        if ((paramString.oGH) && ((this.oCI instanceof c)))
        {
          ((c)this.oCI).xs(false);
          ((c)this.oCI).xs(true);
          ((c)this.oCI).ZD();
        }
        if ((((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMn, Boolean.FALSE)).booleanValue()) && (paramString.oGJ != null))
        {
          cF(paramString.oGJ.HJu);
          if ((this.oCI instanceof c))
          {
            ((c)this.oCI).xs(false);
            ((c)this.oCI).xs(true);
            ((c)this.oCI).ZD();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI
 * JD-Core Version:    0.7.0.1
 */