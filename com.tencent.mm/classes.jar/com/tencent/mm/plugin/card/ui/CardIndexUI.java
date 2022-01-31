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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boo;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CardIndexUI
  extends CardBaseUI
{
  private final String TAG = "MicroMsg.CardIndexUI";
  int fromScene = 0;
  private View ivd;
  private TextView ive;
  private f ivf;
  private TextView ivg;
  private TextView ivh;
  private ImageView ivi;
  private LinearLayout ivj;
  int ivk = -1;
  private long mStartTime = 0L;
  
  private void aQ(List<bon> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (bon)paramList.next();
        if (((bon)localObject1).sHP == 1)
        {
          y.i("MicroMsg.CardIndexUI", "should update new invoice");
          localObject1 = ((bon)localObject1).tGO;
          this.ijI.removeAllViews();
          this.ijI.setPadding(0, 0, 0, 0);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            int i = 0;
            label99:
            Object localObject2;
            View localView;
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ma)((Iterator)localObject1).next();
              localView = View.inflate(this.mController.uMN, a.e.card_invoice_new_item, null);
              CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(a.d.clni_icon_iv);
              TextView localTextView1 = (TextView)localView.findViewById(a.d.clni_title_tv);
              TextView localTextView2 = (TextView)localView.findViewById(a.d.clni_desc_tv);
              localCdnImageView.setUrl(((ma)localObject2).sHY);
              localTextView1.setText(((ma)localObject2).sHX);
              localTextView2.setText(((ma)localObject2).sHZ);
              if (((ma)localObject2).sIa > 0) {
                localView.setOnClickListener(new CardIndexUI.2(this, (ma)localObject2));
              }
              this.ijI.addView(localView);
              if (i != 0) {
                break label263;
              }
              this.ijI.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this, 13), 0, 0);
            }
            for (;;)
            {
              i += 1;
              break label99;
              break;
              label263:
              localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
              if (localObject2 != null)
              {
                ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 6);
                localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
        }
      }
    }
    if ((this.ijI.getChildCount() == 0) && (this.ijG.getCount() == 0))
    {
      y.i("MicroMsg.CardIndexUI", "show empty view");
      this.ijH.setVisibility(0);
      this.ijF.setVisibility(8);
      return;
    }
    y.i("MicroMsg.CardIndexUI", "hide empty view");
    this.ijH.setVisibility(8);
    this.ijF.setVisibility(0);
  }
  
  protected final void ayQ()
  {
    Object localObject;
    if (1 == this.ivk)
    {
      setMMTitle(a.g.card_member_card_title);
      this.ivg = ((TextView)findViewById(a.d.no_card_tip_text));
      this.ivh = ((TextView)findViewById(a.d.no_card_tip_title));
      this.ivi = ((ImageView)findViewById(a.d.no_card_tip_img));
      this.ivd = findViewById(a.d.card_experience_layout);
      this.ive = ((TextView)findViewById(a.d.card_experience_url_tv));
      this.ivj = ((LinearLayout)findViewById(a.d.no_card_tip_layout));
      this.ivd.setVisibility(8);
      this.ivh.setVisibility(0);
      this.ivg.setVisibility(0);
      this.ivi.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.ivj.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.b.b(this, 100.0F);
      this.ivj.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.ivk) {
        break label358;
      }
      this.ivh.setText(getString(a.g.card_list_member_card_empty_tips_title));
      this.ivg.setText(getString(a.g.card_list_member_card_empty_tips));
    }
    for (;;)
    {
      if (this.ivk == 3)
      {
        this.ijF.setEmptyView(null);
        this.ijH.setVisibility(8);
      }
      this.ive.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).imF)) {
            com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).imF, 0);
          }
        }
      });
      if ((this.ivk == 3) && (((Boolean)g.DP().Dz().get(ac.a.upt, Boolean.valueOf(false))).booleanValue()))
      {
        y.i("MicroMsg.CardIndexUI", "has load new entrance");
        localObject = (String)g.DP().Dz().get(ac.a.upr, null);
        if (bk.bl((String)localObject)) {}
      }
      try
      {
        boo localboo = new boo();
        localboo.aH(((String)localObject).getBytes("ISO-8859-1"));
        aQ(localboo.tGP);
        return;
      }
      catch (IOException localIOException)
      {
        label358:
        y.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.ivk)
      {
        setMMTitle(a.g.card_ticket_title);
        break;
      }
      setMMTitle(a.g.card_mm_card_package_new);
      break;
      if (3 == this.ivk)
      {
        this.ivh.setText(getString(a.g.card_list_ticket_card_empty_tips_title));
        this.ivg.setText(getString(a.g.card_list_ticket_card_empty_tips));
      }
      else
      {
        this.ivh.setText(getString(a.g.card_select_list_no_card_tips));
        this.ivg.setText(getString(a.g.card_share_card_list_no_card_tips));
      }
    }
  }
  
  protected final n.a ayR()
  {
    if (1 == this.ivk) {
      return n.a.inj;
    }
    if (3 == this.ivk)
    {
      if (((Boolean)g.DP().Dz().get(ac.a.upt, Boolean.valueOf(false))).booleanValue()) {
        return n.a.inl;
      }
      return n.a.ini;
    }
    return n.a.inf;
  }
  
  protected final void initView()
  {
    if (getIntent() != null) {
      this.ivk = getIntent().getIntExtra("key_card_type", -1);
    }
    super.initView();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.CardIndexUI", "oncreate");
    this.mStartTime = System.currentTimeMillis();
    initView();
    g.DO().dJT.a(984, this);
    am.aAr();
    com.tencent.mm.plugin.card.b.b.oM(1);
    int i = am.aAw().ilg;
    if ((com.tencent.mm.y.c.BS().bb(262152, 266256)) || (i > 0))
    {
      h.nFQ.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      return;
    }
    h.nFQ.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
  }
  
  protected void onDestroy()
  {
    g.DO().dJT.b(984, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    h.nFQ.f(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof x)) {
        break label188;
      }
      this.ivf = i.yP((String)g.DP().Dz().get(282885, ""));
      if (this.ivf == null) {
        this.ivf = new f();
      }
      if ((this.ivf != null) && (!TextUtils.isEmpty(this.ivf.imD))) {
        this.ivg.setText(this.ivf.imD);
      }
      if ((this.ivf != null) && (this.ivf.imG)) {
        break label129;
      }
      this.ivd.setVisibility(8);
    }
    label129:
    label188:
    do
    {
      do
      {
        do
        {
          return;
          this.ive.setText(this.ivf.imE);
          if ((!TextUtils.isEmpty(this.ivf.imE)) && (!TextUtils.isEmpty(this.ivf.imF)))
          {
            this.ivd.setVisibility(0);
            return;
          }
          this.ivd.setVisibility(8);
          return;
        } while (!(paramm instanceof ad));
        paramString = (ad)paramm;
        if ((paramString.inE) && ((this.ijG instanceof c)))
        {
          ((c)this.ijG).mR(false);
          ((c)this.ijG).mR(true);
          ((c)this.ijG).yc();
        }
      } while ((!((Boolean)g.DP().Dz().get(ac.a.upt, Boolean.valueOf(false))).booleanValue()) || (paramString.inG == null));
      aQ(paramString.inG.tGP);
    } while (!(this.ijG instanceof c));
    ((c)this.ijG).mR(false);
    ((c)this.ijG).mR(true);
    ((c)this.ijG).yc();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  protected final BaseAdapter xX()
  {
    if (3 == this.ivk) {
      return new k(this, ayR());
    }
    return new c(this, ayR());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI
 * JD-Core Version:    0.7.0.1
 */