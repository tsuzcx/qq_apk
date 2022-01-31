package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.d.bq;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.bu;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.cz;
import com.tencent.mm.plugin.game.d.u;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;
import com.tencent.mm.plugin.game.model.aa.b;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.applet.t.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements f
{
  private String appId = null;
  private Dialog jwv;
  private com.tencent.mm.plugin.game.model.d kOM = null;
  private int kQh = 0;
  private com.tencent.mm.plugin.game.model.l kZA = null;
  private ViewGroup kZB;
  private ImageView kZC;
  private ImageView kZD;
  private TextView kZE;
  private Button kZF;
  private TextProgressBar kZG;
  private TextView kZH;
  private LinearLayout kZI;
  private GameDetailAutoScrollView kZJ;
  private LinearLayout kZK;
  private TextView kZL;
  private LinearLayout kZM;
  private TextView kZN;
  private LinearLayout kZO;
  private ImageView kZP;
  private View kZQ;
  private TextView kZR;
  private TextView kZS;
  private View kZT;
  private TextView kZU;
  private ImageView kZV;
  private TextView kZW;
  private TextView kZX;
  private LinearLayout kZY;
  private GameMediaList kZZ;
  private String kZr = null;
  private String kZs = null;
  private int kZu = 18;
  private boolean kZv;
  private boolean kZw;
  private String kZx = null;
  private k.a kZy = null;
  private d kZz = null;
  private TextView laa;
  private TextView lab;
  private TextView lac;
  private boolean lad = false;
  private LinearLayout lae;
  private TextView laf;
  private LinearLayout lag;
  private TextView lah;
  private cz lai;
  private DialogInterface.OnClickListener laj = new GameDetailUI2.15(this);
  private View.OnClickListener lak = new GameDetailUI2.16(this);
  private View.OnClickListener lal = new GameDetailUI2.17(this);
  private View.OnClickListener lam = new GameDetailUI2.2(this);
  private View.OnClickListener lan = new GameDetailUI2.3(this);
  private View.OnClickListener lao = new GameDetailUI2.4(this);
  private View.OnClickListener lap = new GameDetailUI2.5(this);
  
  private void a(aa paramaa)
  {
    Object localObject1 = null;
    if ((paramaa.kQr.kQs == null) || (paramaa.kQr.kQs.size() == 0)) {
      localObject1 = paramaa.kQo.kUq;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.kZI.setVisibility(8);
      return;
    }
    this.kZI.setVisibility(0);
    this.kZI.removeAllViews();
    paramaa = ((LinkedList)localObject1).iterator();
    label76:
    View localView;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    if (paramaa.hasNext())
    {
      localObject1 = (u)paramaa.next();
      localView = LayoutInflater.from(this.mController.uMN).inflate(g.f.game_detail2_trend_item, this.kZI, false);
      localImageView = (ImageView)localView.findViewById(g.e.game_detail_trend_item_icon);
      localTextView1 = (TextView)localView.findViewById(g.e.game_detail_trend_item_title);
      localTextView2 = (TextView)localView.findViewById(g.e.game_detail_trend_item_detail);
      if (bk.bl(((u)localObject1).hPY)) {
        break label205;
      }
      a.b.a(localImageView, ((u)localObject1).hPY, 0.5F, false);
    }
    for (;;)
    {
      localTextView1.setText(((u)localObject1).bGw);
      localTextView2.setText(((u)localObject1).kSY);
      this.kZI.addView(localView);
      break label76;
      break;
      label205:
      Object localObject2 = new c.a();
      ((c.a)localObject2).erD = true;
      localObject2 = ((c.a)localObject2).OV();
      o.ON().a(((u)localObject1).kRY, localImageView, (com.tencent.mm.as.a.a.c)localObject2);
    }
  }
  
  private void b(aa paramaa)
  {
    if ((paramaa.aZy() != null) && (!paramaa.aZy().isEmpty()))
    {
      this.kZM.setVisibility(0);
      int i;
      if (!bk.bl(paramaa.aZx()))
      {
        this.kZN.setVisibility(0);
        this.kZN.setText(paramaa.aZx());
        this.kZO.removeAllViews();
        if (paramaa.aZz() != 1) {
          break label268;
        }
        this.kZO.setOrientation(1);
        i = g.f.game_detail2_gift_item;
        this.kZP.setVisibility(8);
      }
      Object localObject;
      for (;;)
      {
        localObject = paramaa.aZy();
        if (localObject == null) {
          break label291;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          aa.b localb = (aa.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(this.mController.uMN).inflate(i, this.kZO, false);
          ImageView localImageView = (ImageView)localView.findViewById(g.e.game_detail_gift_item_icon);
          o.ON().a(localb.bVO, localImageView);
          if (paramaa.aZz() == 1) {
            ((TextView)localView.findViewById(g.e.game_detail_gift_item_title)).setText(localb.title);
          }
          ((TextView)localView.findViewById(g.e.game_detail_gift_item_detail)).setText(localb.desc);
          if (paramaa.aZz() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.lam);
          }
          this.kZO.addView(localView);
        }
        this.kZN.setVisibility(8);
        break;
        label268:
        this.kZO.setOrientation(0);
        i = g.f.game_detail2_gift2_item;
        this.kZP.setVisibility(0);
      }
      label291:
      if (paramaa.kQo.kUy != null)
      {
        localObject = new aa.a();
        ((aa.a)localObject).title = paramaa.kQo.kUy.summary;
        ((aa.a)localObject).desc = paramaa.kQo.kUy.desc;
        ((aa.a)localObject).url = paramaa.kQo.kUy.url;
        paramaa = (aa)localObject;
        if (paramaa == null) {
          break label528;
        }
        this.kZQ.setVisibility(0);
        this.kZR.setText(paramaa.title);
        if (bk.bl(paramaa.desc)) {
          break label516;
        }
        this.kZS.setVisibility(0);
        this.kZS.setText(paramaa.desc);
      }
      for (;;)
      {
        this.kZQ.setTag(paramaa.url);
        this.kZQ.setOnClickListener(this.lam);
        return;
        if ((paramaa.kQo.kUt != null) && (!bk.bl(paramaa.kQo.kUt.kVg)) && (!bk.bl(paramaa.kQo.kUt.kVh)))
        {
          localObject = new aa.a();
          ((aa.a)localObject).title = paramaa.kQo.kUt.kVg;
          ((aa.a)localObject).url = paramaa.kQo.kUt.kVh;
          paramaa = (aa)localObject;
          break;
        }
        paramaa = null;
        break;
        label516:
        this.kZS.setVisibility(8);
      }
      label528:
      this.kZQ.setVisibility(8);
      return;
    }
    this.kZM.setVisibility(8);
  }
  
  private void b(ab paramab)
  {
    int i = 0;
    List localList = paramab.kQs;
    if ((localList == null) || (localList.size() == 0))
    {
      this.kZK.setVisibility(8);
      this.kZL.setVisibility(8);
      return;
    }
    this.kZK.setVisibility(0);
    if (localList.size() > 3) {
      this.kZL.setVisibility(0);
    }
    for (;;)
    {
      this.kZK.removeAllViews();
      i locali = new i(this.mController.uMN);
      locali.Ls = g.f.game_detail2_rank_item_small;
      locali.a(paramab);
      locali.kQh = this.kQh;
      while ((i < localList.size()) && (i < 3))
      {
        paramab = locali.getView(i, null, this.kZI);
        this.kZK.addView(paramab);
        i += 1;
      }
      break;
      this.kZL.setVisibility(8);
    }
  }
  
  private void c(aa paramaa)
  {
    if ((paramaa.aZE() != null) && (!paramaa.aZE().isEmpty()))
    {
      this.lae.setVisibility(0);
      if (!bk.bl(paramaa.aZD()))
      {
        this.laf.setVisibility(0);
        this.laf.setText(paramaa.aZD());
      }
      for (;;)
      {
        this.lag.removeAllViews();
        this.lag.setOnClickListener(null);
        Iterator localIterator = paramaa.aZE().iterator();
        while (localIterator.hasNext())
        {
          bv localbv = (bv)localIterator.next();
          View localView = LayoutInflater.from(this.mController.uMN).inflate(g.f.game_detail2_guide_item, this.lag, false);
          TextView localTextView1 = (TextView)localView.findViewById(g.e.game_detail_guide_item_tag);
          TextView localTextView2 = (TextView)localView.findViewById(g.e.game_detail_guide_item_title);
          TextView localTextView3 = (TextView)localView.findViewById(g.e.game_detail_guide_item_detail);
          ImageView localImageView = (ImageView)localView.findViewById(g.e.game_detail_guide_item_icon);
          localTextView1.setText(localbv.kVl);
          localTextView2.setText(localbv.bGw);
          localTextView3.setText(localbv.kSY);
          o.ON().a(localbv.kVi, localImageView);
          localView.setTag(localbv.kRS);
          localView.setOnClickListener(this.lan);
          this.lag.addView(localView);
        }
        this.laf.setVisibility(8);
      }
      if (paramaa.kQo.kUt == null) {
        paramaa = null;
      }
      while (paramaa != null)
      {
        this.lah.setVisibility(0);
        this.lah.setText((CharSequence)paramaa.first);
        this.lah.setTag(paramaa.second);
        this.lah.setOnClickListener(this.lao);
        return;
        if ((bk.bl(paramaa.kQo.kUs.bGw)) || (bk.bl(paramaa.kQo.kUs.kVh))) {
          paramaa = null;
        } else {
          paramaa = new Pair(paramaa.kQo.kUs.kVg, paramaa.kQo.kUs.kVh);
        }
      }
      this.lah.setVisibility(8);
      return;
    }
    this.lae.setVisibility(8);
  }
  
  private void goBack()
  {
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bk.bl((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      startActivity((Intent)localObject);
    }
    finish();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return g.f.game_detail2;
  }
  
  protected final void initView()
  {
    setMMTitle(g.i.game_detail_title);
    setBackBtn(new GameDetailUI2.1(this));
    this.kZB = ((ViewGroup)findViewById(g.e.game_detail));
    this.kZC = ((ImageView)findViewById(g.e.game_detail_bg));
    this.kZD = ((ImageView)findViewById(g.e.game_icon));
    this.kZE = ((TextView)findViewById(g.e.game_name));
    this.kZH = ((TextView)findViewById(g.e.game_info));
    this.kZF = ((Button)findViewById(g.e.game_action_btn));
    this.kZG = ((TextProgressBar)findViewById(g.e.game_progress));
    this.kZG.setTextSize(this.kZu);
    this.kZI = ((LinearLayout)findViewById(g.e.game_detail_trend_container));
    this.kZJ = ((GameDetailAutoScrollView)findViewById(g.e.game_detail_trend_brief));
    this.kZK = ((LinearLayout)findViewById(g.e.game_detail_rank_container));
    this.kZL = ((TextView)findViewById(g.e.game_detail_rank_entrance));
    this.kZM = ((LinearLayout)findViewById(g.e.game_detail_gift));
    this.kZN = ((TextView)findViewById(g.e.game_detail_gift_title));
    this.kZO = ((LinearLayout)findViewById(g.e.game_detail_gift_container));
    this.kZP = ((ImageView)findViewById(g.e.game_detail_gift_divider));
    this.kZQ = findViewById(g.e.game_detail_gift_entrance);
    this.kZR = ((TextView)findViewById(g.e.game_detail_gift_entrance_title));
    this.kZS = ((TextView)findViewById(g.e.game_detail_gift_entrance_desc));
    this.kZT = findViewById(g.e.game_detail_group);
    this.kZU = ((TextView)findViewById(g.e.game_detail_group_title));
    this.kZV = ((ImageView)findViewById(g.e.game_detail_group_icon));
    this.kZW = ((TextView)findViewById(g.e.game_detail_group_desc));
    this.kZX = ((TextView)findViewById(g.e.game_detail_group_detail));
    this.kZY = ((LinearLayout)findViewById(g.e.game_detail_desc));
    this.kZZ = ((GameMediaList)findViewById(g.e.game_detail_intro_media));
    GameMediaList localGameMediaList = this.kZZ;
    String str = this.appId;
    int i = this.kQh;
    localGameMediaList.appId = str;
    localGameMediaList.jNi = 12;
    localGameMediaList.lbK = i;
    localGameMediaList.mContext = this;
    this.kZZ.setItemLayout(g.f.game_media_item_big);
    this.laa = ((TextView)findViewById(g.e.game_detail_desc_title));
    this.lab = ((TextView)findViewById(g.e.game_detail_desc_content));
    this.lab.getViewTreeObserver().addOnGlobalLayoutListener(new GameDetailUI2.10(this));
    this.lac = ((TextView)findViewById(g.e.game_detail_desc_toggle));
    this.lac.setOnClickListener(new GameDetailUI2.11(this));
    this.lae = ((LinearLayout)findViewById(g.e.game_detail_guide));
    this.laf = ((TextView)findViewById(g.e.game_detail_guide_title));
    this.lag = ((LinearLayout)findViewById(g.e.game_detail_guide_container));
    this.lah = ((TextView)findViewById(g.e.game_detail_guide_entrance));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      y.e("MicroMsg.GameDetailUI2", "error request code");
    }
    do
    {
      String str2;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              switch (paramInt2)
              {
              case 0: 
              case 1: 
              default: 
                return;
              }
            } while ((this.kOM == null) || (this.kZA == null));
            this.kZA.aZk();
            this.kZz.a(this.kOM, this.kZA);
            return;
          } while (this.kZA == null);
          this.kZA.aGu();
          return;
        } while (paramInt2 != -1);
        str2 = paramIntent.getStringExtra("Select_Conv_User");
      } while (bk.bl(str2));
      String str1 = this.lai.kRY;
      paramIntent = str1;
      if (bk.bl(str1)) {
        paramIntent = this.kOM.field_appIconUrl;
      }
      t.a.sdu.a(this.mController, this.lai.kWe, paramIntent, this.lai.kWf, true, getResources().getString(g.i.app_send), new GameDetailUI2.9(this, str2));
      return;
    } while (paramInt2 != -1);
    com.tencent.mm.plugin.game.e.b.a(this.mController.uMN, 12, 1207, 2, 15, this.appId, this.kQh, null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.DK())
    {
      y.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      return;
    }
    this.kZv = true;
    this.kZw = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (bk.bl(this.appId))
    {
      y.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      com.tencent.mm.kernel.g.Dk().a(1217, this);
      paramBundle = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYg().Ey(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label202;
      }
      y.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.jwv = com.tencent.mm.plugin.game.f.c.dA(this);
        this.jwv.show();
      }
      paramBundle = com.tencent.mm.sdk.platformtools.x.cqJ();
      boolean bool = com.tencent.mm.pluginsdk.model.app.g.o(this, this.appId);
      paramBundle = new an(paramBundle, this.appId, bool);
      com.tencent.mm.kernel.g.Dk().a(paramBundle, 0);
      return;
      this.kQh = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label202:
      com.tencent.mm.kernel.g.DS().O(new GameDetailUI2.12(this, paramBundle));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.Dk().b(1217, this);
    if (this.kZy != null) {
      k.b(this.kZy);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.kOM != null) && (this.kZA != null))
    {
      this.kZA.aGu();
      this.kZz.a(this.kZG, this.kZF, this.kOM, this.kZA);
    }
    if (!this.kZv)
    {
      b(new ab(this.appId));
      return;
    }
    this.kZv = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.b.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(g.i.game_list_get_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.jwv != null) {
        this.jwv.cancel();
      }
      return;
    }
    switch (paramm.getType())
    {
    default: 
      return;
    }
    paramString = ((an)paramm).jvQ.ecF.ecN;
    com.tencent.mm.kernel.g.DS().O(new GameDetailUI2.14(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2
 * JD-Core Version:    0.7.0.1
 */