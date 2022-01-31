package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.bs;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.d.da;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.game.model.z.a;
import com.tencent.mm.plugin.game.model.z.b;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.applet.t.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2
  extends MMActivity
  implements f
{
  private String appId;
  private Dialog lFU;
  private com.tencent.mm.plugin.game.model.c nmJ;
  private int nok;
  private ImageView nxA;
  private TextView nxB;
  private Button nxC;
  private TextProgressBar nxD;
  private TextView nxE;
  private LinearLayout nxF;
  private GameDetailAutoScrollView nxG;
  private LinearLayout nxH;
  private TextView nxI;
  private LinearLayout nxJ;
  private TextView nxK;
  private LinearLayout nxL;
  private ImageView nxM;
  private View nxN;
  private TextView nxO;
  private TextView nxP;
  private View nxQ;
  private TextView nxR;
  private ImageView nxS;
  private TextView nxT;
  private TextView nxU;
  private LinearLayout nxV;
  private GameMediaList nxW;
  private TextView nxX;
  private TextView nxY;
  private TextView nxZ;
  private String nxo;
  private String nxp;
  private int nxr;
  private boolean nxs;
  private boolean nxt;
  private String nxu;
  private j.a nxv;
  private d nxw;
  private k nxx;
  private ViewGroup nxy;
  private ImageView nxz;
  private boolean nya;
  private LinearLayout nyb;
  private TextView nyc;
  private LinearLayout nyd;
  private TextView nye;
  private da nyf;
  private DialogInterface.OnClickListener nyg;
  private View.OnClickListener nyh;
  private View.OnClickListener nyi;
  private View.OnClickListener nyj;
  private View.OnClickListener nyk;
  private View.OnClickListener nyl;
  private View.OnClickListener nym;
  
  public GameDetailUI2()
  {
    AppMethodBeat.i(111859);
    this.appId = null;
    this.nmJ = null;
    this.nxo = null;
    this.nxp = null;
    this.nxr = 18;
    this.nok = 0;
    this.nxu = null;
    this.nxv = null;
    this.nxw = null;
    this.nxx = null;
    this.nya = false;
    this.nyg = new GameDetailUI2.15(this);
    this.nyh = new GameDetailUI2.16(this);
    this.nyi = new GameDetailUI2.17(this);
    this.nyj = new GameDetailUI2.2(this);
    this.nyk = new GameDetailUI2.3(this);
    this.nyl = new GameDetailUI2.4(this);
    this.nym = new GameDetailUI2.5(this);
    AppMethodBeat.o(111859);
  }
  
  private void a(z paramz)
  {
    AppMethodBeat.i(111868);
    Object localObject1 = null;
    if ((paramz.nov.now == null) || (paramz.nov.now.size() == 0)) {
      localObject1 = paramz.nos.nss;
    }
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      this.nxF.setVisibility(8);
      AppMethodBeat.o(111868);
      return;
    }
    this.nxF.setVisibility(0);
    this.nxF.removeAllViews();
    paramz = ((LinkedList)localObject1).iterator();
    if (paramz.hasNext())
    {
      localObject1 = (v)paramz.next();
      View localView = LayoutInflater.from(getContext()).inflate(2130969737, this.nxF, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131824593);
      TextView localTextView1 = (TextView)localView.findViewById(2131824594);
      TextView localTextView2 = (TextView)localView.findViewById(2131824595);
      if (!bo.isNullOrNil(((v)localObject1).jJA)) {
        a.b.a(localImageView, ((v)localObject1).jJA, 0.5F, false);
      }
      for (;;)
      {
        localTextView1.setText(((v)localObject1).Title);
        localTextView2.setText(((v)localObject1).nqY);
        this.nxF.addView(localView);
        break;
        Object localObject2 = new c.a();
        ((c.a)localObject2).eOk = true;
        localObject2 = ((c.a)localObject2).ahY();
        o.ahG().a(((v)localObject1).nqa, localImageView, (com.tencent.mm.at.a.a.c)localObject2);
      }
    }
    AppMethodBeat.o(111868);
  }
  
  private void b(com.tencent.mm.plugin.game.model.aa paramaa)
  {
    int i = 0;
    AppMethodBeat.i(111867);
    List localList = paramaa.now;
    if ((localList == null) || (localList.size() == 0))
    {
      this.nxH.setVisibility(8);
      this.nxI.setVisibility(8);
      AppMethodBeat.o(111867);
      return;
    }
    this.nxH.setVisibility(0);
    if (localList.size() > 3) {
      this.nxI.setVisibility(0);
    }
    for (;;)
    {
      this.nxH.removeAllViews();
      i locali = new i(getContext());
      locali.Ld = 2130969734;
      locali.a(paramaa);
      locali.nok = this.nok;
      while ((i < localList.size()) && (i < 3))
      {
        paramaa = locali.getView(i, null, this.nxF);
        this.nxH.addView(paramaa);
        i += 1;
      }
      this.nxI.setVisibility(8);
    }
    AppMethodBeat.o(111867);
  }
  
  private void b(z paramz)
  {
    AppMethodBeat.i(111869);
    if ((paramz.bGB() != null) && (!paramz.bGB().isEmpty()))
    {
      this.nxJ.setVisibility(0);
      if (!bo.isNullOrNil(paramz.bGA()))
      {
        this.nxK.setVisibility(0);
        this.nxK.setText(paramz.bGA());
        this.nxL.removeAllViews();
        if (paramz.bGC() != 1) {
          break label271;
        }
        this.nxL.setOrientation(1);
        this.nxM.setVisibility(8);
      }
      Object localObject;
      for (int i = 2130969729;; i = 2130969728)
      {
        localObject = paramz.bGB();
        if (localObject == null) {
          break label294;
        }
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          z.b localb = (z.b)((Iterator)localObject).next();
          View localView = LayoutInflater.from(getContext()).inflate(i, this.nxL, false);
          ImageView localImageView = (ImageView)localView.findViewById(2131824573);
          o.ahG().a(localb.cDz, localImageView);
          if (paramz.bGC() == 1) {
            ((TextView)localView.findViewById(2131824575)).setText(localb.title);
          }
          ((TextView)localView.findViewById(2131824574)).setText(localb.desc);
          if (paramz.bGC() == 1)
          {
            localView.setTag(localb.url);
            localView.setOnClickListener(this.nyj);
          }
          this.nxL.addView(localView);
        }
        this.nxK.setVisibility(8);
        break;
        label271:
        this.nxL.setOrientation(0);
        this.nxM.setVisibility(0);
      }
      label294:
      if (paramz.nos.nsA != null)
      {
        localObject = new z.a();
        ((z.a)localObject).title = paramz.nos.nsA.summary;
        ((z.a)localObject).desc = paramz.nos.nsA.desc;
        ((z.a)localObject).url = paramz.nos.nsA.url;
        paramz = (z)localObject;
        if (paramz == null) {
          break label537;
        }
        this.nxN.setVisibility(0);
        this.nxO.setText(paramz.title);
        if (bo.isNullOrNil(paramz.desc)) {
          break label525;
        }
        this.nxP.setVisibility(0);
        this.nxP.setText(paramz.desc);
      }
      for (;;)
      {
        this.nxN.setTag(paramz.url);
        this.nxN.setOnClickListener(this.nyj);
        AppMethodBeat.o(111869);
        return;
        if ((paramz.nos.nsv != null) && (!bo.isNullOrNil(paramz.nos.nsv.nti)) && (!bo.isNullOrNil(paramz.nos.nsv.ntj)))
        {
          localObject = new z.a();
          ((z.a)localObject).title = paramz.nos.nsv.nti;
          ((z.a)localObject).url = paramz.nos.nsv.ntj;
          paramz = (z)localObject;
          break;
        }
        paramz = null;
        break;
        label525:
        this.nxP.setVisibility(8);
      }
      label537:
      this.nxN.setVisibility(8);
      AppMethodBeat.o(111869);
      return;
    }
    this.nxJ.setVisibility(8);
    AppMethodBeat.o(111869);
  }
  
  private void bHl()
  {
    AppMethodBeat.i(111865);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      startActivity((Intent)localObject);
    }
    AppMethodBeat.o(111865);
  }
  
  private void c(z paramz)
  {
    AppMethodBeat.i(111870);
    if ((paramz.bGH() != null) && (!paramz.bGH().isEmpty()))
    {
      this.nyb.setVisibility(0);
      if (!bo.isNullOrNil(paramz.bGG()))
      {
        this.nyc.setVisibility(0);
        this.nyc.setText(paramz.bGG());
      }
      for (;;)
      {
        this.nyd.removeAllViews();
        this.nyd.setOnClickListener(null);
        Iterator localIterator = paramz.bGH().iterator();
        while (localIterator.hasNext())
        {
          bw localbw = (bw)localIterator.next();
          View localView = LayoutInflater.from(getContext()).inflate(2130969730, this.nyd, false);
          TextView localTextView1 = (TextView)localView.findViewById(2131824576);
          TextView localTextView2 = (TextView)localView.findViewById(2131824577);
          TextView localTextView3 = (TextView)localView.findViewById(2131824578);
          ImageView localImageView = (ImageView)localView.findViewById(2131824579);
          localTextView1.setText(localbw.ntn);
          localTextView2.setText(localbw.Title);
          localTextView3.setText(localbw.nqY);
          o.ahG().a(localbw.ntk, localImageView);
          localView.setTag(localbw.npU);
          localView.setOnClickListener(this.nyk);
          this.nyd.addView(localView);
        }
        this.nyc.setVisibility(8);
      }
      if (paramz.nos.nsv == null) {
        paramz = null;
      }
      while (paramz != null)
      {
        this.nye.setVisibility(0);
        this.nye.setText((CharSequence)paramz.first);
        this.nye.setTag(paramz.second);
        this.nye.setOnClickListener(this.nyl);
        AppMethodBeat.o(111870);
        return;
        if ((bo.isNullOrNil(paramz.nos.nsu.Title)) || (bo.isNullOrNil(paramz.nos.nsu.ntj))) {
          paramz = null;
        } else {
          paramz = new Pair(paramz.nos.nsu.nti, paramz.nos.nsu.ntj);
        }
      }
      this.nye.setVisibility(8);
      AppMethodBeat.o(111870);
      return;
    }
    this.nyb.setVisibility(8);
    AppMethodBeat.o(111870);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(111864);
    bHl();
    finish();
    AppMethodBeat.o(111864);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969726;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111866);
    setMMTitle(2131300355);
    setBackBtn(new GameDetailUI2.1(this));
    this.nxy = ((ViewGroup)findViewById(2131824547));
    this.nxz = ((ImageView)findViewById(2131824548));
    this.nxA = ((ImageView)findViewById(2131821573));
    this.nxB = ((TextView)findViewById(2131821575));
    this.nxE = ((TextView)findViewById(2131824537));
    this.nxC = ((Button)findViewById(2131824569));
    this.nxD = ((TextProgressBar)findViewById(2131824570));
    this.nxD.setTextSize(this.nxr);
    this.nxF = ((LinearLayout)findViewById(2131824541));
    this.nxG = ((GameDetailAutoScrollView)findViewById(2131824549));
    this.nxH = ((LinearLayout)findViewById(2131824550));
    this.nxI = ((TextView)findViewById(2131824542));
    this.nxJ = ((LinearLayout)findViewById(2131824551));
    this.nxK = ((TextView)findViewById(2131824552));
    this.nxL = ((LinearLayout)findViewById(2131824553));
    this.nxM = ((ImageView)findViewById(2131824554));
    this.nxN = findViewById(2131824555);
    this.nxO = ((TextView)findViewById(2131824556));
    this.nxP = ((TextView)findViewById(2131824557));
    this.nxQ = findViewById(2131824560);
    this.nxR = ((TextView)findViewById(2131824561));
    this.nxS = ((ImageView)findViewById(2131824562));
    this.nxT = ((TextView)findViewById(2131824563));
    this.nxU = ((TextView)findViewById(2131824564));
    this.nxV = ((LinearLayout)findViewById(2131824558));
    this.nxW = ((GameMediaList)findViewById(2131824544));
    GameMediaList localGameMediaList = this.nxW;
    String str = this.appId;
    int i = this.nok;
    localGameMediaList.appId = str;
    localGameMediaList.mhr = 12;
    localGameMediaList.nzF = i;
    localGameMediaList.mContext = this;
    this.nxW.setItemLayout(2130969785);
    this.nxX = ((TextView)findViewById(2131824543));
    this.nxY = ((TextView)findViewById(2131824546));
    this.nxY.getViewTreeObserver().addOnGlobalLayoutListener(new GameDetailUI2.10(this));
    this.nxZ = ((TextView)findViewById(2131824559));
    this.nxZ.setOnClickListener(new GameDetailUI2.11(this));
    this.nyb = ((LinearLayout)findViewById(2131824565));
    this.nyc = ((TextView)findViewById(2131824566));
    this.nyd = ((LinearLayout)findViewById(2131824567));
    this.nye = ((TextView)findViewById(2131824568));
    AppMethodBeat.o(111866);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(111872);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ab.e("MicroMsg.GameDetailUI2", "error request code");
      AppMethodBeat.o(111872);
      return;
    case 1: 
      switch (paramInt2)
      {
      case 1: 
      default: 
        AppMethodBeat.o(111872);
        return;
      case 3: 
        if (this.nxx != null)
        {
          this.nxx.bjZ();
          AppMethodBeat.o(111872);
          return;
        }
        break;
      case 2: 
        if ((this.nmJ != null) && (this.nxx != null))
        {
          this.nxx.bGk();
          this.nxw.a(this.nmJ, this.nxx);
          AppMethodBeat.o(111872);
          return;
        }
        break;
      case 0: 
        AppMethodBeat.o(111872);
        return;
      }
      break;
    case 2: 
      if (paramInt2 == -1)
      {
        String str2 = paramIntent.getStringExtra("Select_Conv_User");
        if (!bo.isNullOrNil(str2))
        {
          String str1 = this.nyf.nqa;
          paramIntent = str1;
          if (bo.isNullOrNil(str1)) {
            paramIntent = this.nmJ.field_appIconUrl;
          }
          t.a.vUz.a(this.mController, this.nyf.nud, paramIntent, this.nyf.nue, true, getResources().getString(2131297067), new GameDetailUI2.9(this, str2));
        }
        AppMethodBeat.o(111872);
        return;
      }
      break;
    case 3: 
      if (paramInt2 == -1)
      {
        com.tencent.mm.game.report.c.a(getContext(), 12, 1207, 2, 15, this.appId, this.nok, null);
        AppMethodBeat.o(111872);
        return;
      }
      break;
    }
    AppMethodBeat.o(111872);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111860);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.e("MicroMsg.GameDetailUI2", "account not ready");
      finish();
      AppMethodBeat.o(111860);
      return;
    }
    this.nxs = true;
    this.nxt = false;
    this.appId = getIntent().getStringExtra("game_app_id");
    if (bo.isNullOrNil(this.appId))
    {
      ab.e("MicroMsg.GameDetailUI2", "appid is null or nill");
      finish();
      initView();
      com.tencent.mm.kernel.g.Rc().a(1217, this);
      paramBundle = ((e)com.tencent.mm.kernel.g.E(e.class)).bET().PN(this.appId);
      if ((paramBundle != null) && (paramBundle.length != 0)) {
        break label220;
      }
      ab.i("MicroMsg.GameDetailUI2", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.lFU = com.tencent.mm.plugin.game.f.c.en(this);
        this.lFU.show();
      }
      paramBundle = com.tencent.mm.sdk.platformtools.aa.dsG();
      boolean bool = com.tencent.mm.pluginsdk.model.app.g.u(this, this.appId);
      paramBundle = new am(paramBundle, this.appId, bool);
      com.tencent.mm.kernel.g.Rc().a(paramBundle, 0);
      AppMethodBeat.o(111860);
      return;
      this.nok = getIntent().getIntExtra("game_report_from_scene", 0);
      break;
      label220:
      com.tencent.mm.kernel.g.RO().ac(new GameDetailUI2.12(this, paramBundle));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111862);
    super.onDestroy();
    com.tencent.mm.kernel.g.Rc().b(1217, this);
    if (this.nxv != null) {
      j.b(this.nxv);
    }
    AppMethodBeat.o(111862);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111863);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(111863);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(111863);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111861);
    super.onResume();
    if ((this.nmJ != null) && (this.nxx != null))
    {
      this.nxx.bjZ();
      this.nxw.a(this.nxD, this.nxC, this.nmJ, this.nxx);
    }
    if (!this.nxs)
    {
      b(new com.tencent.mm.plugin.game.model.aa(this.appId));
      AppMethodBeat.o(111861);
      return;
    }
    this.nxs = false;
    AppMethodBeat.o(111861);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(111871);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (!com.tencent.mm.plugin.game.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(2131300407, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.lFU != null) {
        this.lFU.cancel();
      }
      AppMethodBeat.o(111871);
      return;
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111871);
      return;
      paramString = ((am)paramm).lFp.fsW.fta;
      com.tencent.mm.kernel.g.RO().ac(new GameDetailUI2.14(this, paramString));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2
 * JD-Core Version:    0.7.0.1
 */