package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.protocal.c.aaa;
import com.tencent.mm.protocal.c.aab;
import com.tencent.mm.protocal.c.zt;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.protocal.c.zx;
import com.tencent.mm.protocal.c.zy;
import com.tencent.mm.protocal.c.zz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.tools.n.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class GameSearchUI
  extends MMActivity
  implements com.tencent.mm.ah.f, n.b
{
  private static final Pattern lfs = Pattern.compile("\\s+");
  private View drU;
  private n drn;
  private int fromScene;
  private ProgressBar frw;
  private TextView kAU;
  private LinkedList<String> lfA;
  private String lfB;
  private LinkedList<m> lfC = new LinkedList();
  private boolean lfD = false;
  private AdapterView.OnItemClickListener lfE = new GameSearchUI.5(this);
  private AdapterView.OnItemClickListener lfF = new GameSearchUI.6(this);
  private ViewGroup lft;
  private ListView lfu;
  private ListView lfv;
  private r lfw;
  private s lfx;
  private String lfy;
  private String lfz;
  
  private void W(LinkedList<String> paramLinkedList)
  {
    a(paramLinkedList, 0, true);
  }
  
  private void a(LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    while (!this.lfC.isEmpty())
    {
      g.DQ();
      g.DO().dJT.c((m)this.lfC.pop());
    }
    if (paramBoolean)
    {
      localObject = this.lfw;
      ((r)localObject).kQn = 0;
      ((r)localObject).leM = false;
    }
    this.lfA = paramLinkedList;
    Object localObject = new al(x.cqJ(), paramLinkedList, com.tencent.mm.plugin.game.model.f.aYT(), this.lfw.kQn);
    g.Dk().a((m)localObject, 0);
    this.lfC.add(localObject);
    paramLinkedList = paramLinkedList.iterator();
    for (this.lfy = ""; paramLinkedList.hasNext(); this.lfy = (this.lfy + " " + (String)paramLinkedList.next())) {}
    this.lfy = this.lfy.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.lfD = true;
      this.drn.setSearchContent(this.lfy);
    }
  }
  
  private void nD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.lft.setVisibility(8);
      this.kAU.setVisibility(8);
      this.lfu.setVisibility(8);
      this.lfv.setVisibility(8);
      this.frw.setVisibility(8);
      return;
    case 1: 
      XM();
      this.lfu.smoothScrollToPosition(0);
      this.drn.clearFocus();
      this.lft.setVisibility(8);
      this.kAU.setVisibility(8);
      this.lfu.setVisibility(8);
      this.lfv.setVisibility(8);
      this.frw.setVisibility(0);
      return;
    case 6: 
      this.lfu.smoothScrollToPosition(0);
      this.lft.setVisibility(8);
      this.kAU.setVisibility(8);
      this.lfu.setVisibility(8);
      this.lfv.setVisibility(8);
      this.frw.setVisibility(0);
      return;
    case 2: 
      this.lft.setVisibility(8);
      if (this.lfw.getCount() > 0)
      {
        this.kAU.setVisibility(8);
        this.lfu.setVisibility(0);
      }
      for (;;)
      {
        this.lfv.setVisibility(8);
        this.frw.setVisibility(8);
        return;
        this.kAU.setVisibility(0);
        this.lfu.setVisibility(8);
      }
    case 3: 
      this.lft.setVisibility(0);
      this.kAU.setVisibility(8);
      this.lfu.setVisibility(8);
      this.lfv.setVisibility(8);
      this.frw.setVisibility(8);
      return;
    case 4: 
      this.lft.setVisibility(8);
      this.kAU.setVisibility(0);
      this.lfu.setVisibility(8);
      this.lfv.setVisibility(8);
      this.frw.setVisibility(8);
      return;
    }
    this.lft.setVisibility(8);
    this.kAU.setVisibility(8);
    this.lfu.setVisibility(8);
    this.lfv.setVisibility(0);
    this.frw.setVisibility(8);
  }
  
  public final void Wl()
  {
    XM();
    onBackPressed();
  }
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  protected final int getLayoutId()
  {
    return g.f.game_search_layout;
  }
  
  protected final void initView()
  {
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GameSearchUI.this.onBackPressed();
        return true;
      }
    });
    this.drn = new n();
    this.drn.nK(true);
    this.drn.weq = this;
    this.lft = ((ViewGroup)findViewById(g.e.voicesearch_view));
    this.frw = ((ProgressBar)findViewById(g.e.search_progress_bar));
    this.kAU = ((TextView)findViewById(g.e.no_result));
    this.lfu = ((ListView)findViewById(g.e.search_result));
    this.lfw = new r(this);
    this.lfu.setAdapter(this.lfw);
    this.lfu.setOnItemClickListener(this.lfE);
    this.lfu.setOnTouchListener(new GameSearchUI.2(this));
    this.lfu.setOnScrollListener(new GameSearchUI.3(this));
    this.drU = getLayoutInflater().inflate(g.f.game_list_footer_loading, this.lfu, false);
    this.drU.setVisibility(8);
    this.lfu.addFooterView(this.drU);
    this.lfv = ((ListView)findViewById(g.e.search_recmd));
    this.lfx = new s(this);
    this.lfv.setAdapter(this.lfx);
    this.lfv.setOnItemClickListener(this.lfF);
    this.lfv.setOnTouchListener(new GameSearchUI.4(this));
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    if (!g.DK())
    {
      y.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      return;
    }
    g.Dk().a(1328, this);
    g.Dk().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    com.tencent.mm.plugin.game.e.b.a(this, 14, 1401, 0, 2, this.fromScene, null);
    y.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.drn.a(this, paramMenu);
    this.drn.setHint(com.tencent.mm.plugin.game.model.f.aZg());
    return true;
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    g.Dk().b(1328, this);
    g.Dk().b(1329, this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.drn.a(this, paramMenu);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.aSd) {}
    label264:
    label583:
    label602:
    label622:
    label637:
    do
    {
      return;
      if (this.lfC.contains(paramm)) {
        this.lfC.remove(paramm);
      }
      this.drU.setVisibility(8);
      switch (paramm.getType())
      {
      default: 
        return;
      case 1328: 
        paramString = (zx)((al)paramm).jvQ.ecE.ecN;
        y.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.sZh, Integer.valueOf(paramString.sZi) });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (zy)((al)paramm).jvQ.ecF.ecN;
          Object localObject3;
          Object localObject4;
          if (paramString != null)
          {
            paramString = paramString.sZj;
            if (bk.dk(paramString)) {
              break label1749;
            }
            this.lfz = this.lfy;
            if (this.lfw.kQn != 0)
            {
              paramm = this.lfw;
              localObject1 = this.lfz;
              paramString = paramString.iterator();
            }
          }
          else
          {
            for (;;)
            {
              if (!paramString.hasNext()) {
                break label1749;
              }
              localObject2 = (zz)paramString.next();
              if ((((zz)localObject2).type == 3) && (!bk.dk(((zz)localObject2).sZl)))
              {
                paramm.kQn = ((zz)localObject2).sZp;
                paramm.leM = ((zz)localObject2).sZq;
                localObject2 = ((zz)localObject2).sZl.iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  localObject3 = r.b.a((aab)((Iterator)localObject2).next());
                  ((r.b)localObject3).bGm = ((String)localObject1);
                  ((r.b)localObject3).lfi.appId = ((r.b)localObject3).appId;
                  ((r.b)localObject3).lfi.lfe = ((r.b)localObject3).lfe;
                  ((r.b)localObject3).lfi.lff = ((r.b)localObject3).lff;
                  ((r.b)localObject3).lfi.lfk = "2";
                  localObject4 = ((r.b)localObject3).lfi;
                  paramInt1 = paramm.leJ;
                  paramm.leJ = (paramInt1 + 1);
                  ((r.c)localObject4).position = (paramInt1 + 301);
                  localObject4 = ((r.b)localObject3).lfi;
                  if (paramm.bGq) {}
                  for (paramInt1 = 1403;; paramInt1 = 1405)
                  {
                    ((r.c)localObject4).bXn = paramInt1;
                    paramm.iBu.add(localObject3);
                    break label264;
                    paramString = null;
                    break;
                  }
                }
              }
              else
              {
                paramm.leM = false;
              }
            }
          }
          paramm = this.lfw;
          localObject1 = this.lfz;
          if (paramm.iBu == null) {
            paramm.iBu = new ArrayList();
          }
          paramm.lcn = 0;
          paramm.leH = 0;
          paramm.leI = 0;
          paramm.leJ = 0;
          paramm.leK = 0;
          paramm.bGq = false;
          paramm.leG = false;
          paramm.leM = false;
          paramm.kQn = 0;
          paramm.iBu.clear();
          paramm.leN = false;
          Object localObject2 = paramString.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramString = (zz)((Iterator)localObject2).next();
            int i;
            if ((paramString.sZk == null) || (paramString.sZk.size() == 0))
            {
              paramInt1 = 1;
              if ((paramString.sZl != null) && (paramString.sZl.size() != 0)) {
                break label707;
              }
              paramInt2 = 1;
              if ((paramString.sZo != null) && (paramString.sZo.size() != 0)) {
                break label712;
              }
              i = 1;
              if ((paramInt1 == 0) || (paramInt2 == 0) || (i == 0)) {
                break label718;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label738;
              }
              if (paramString.type != 1) {
                continue;
              }
              if (bk.bl((String)localObject1)) {
                break label723;
              }
            }
            for (paramString = paramm.context.getString(g.i.game_search_no_res_kw, new Object[] { localObject1 });; paramString = paramm.context.getString(g.i.game_search_no_res))
            {
              paramm.iBu.add(r.b.as(6, paramString));
              paramm.leN = true;
              break;
              paramInt1 = 0;
              break label583;
              paramInt2 = 0;
              break label602;
              i = 0;
              break label622;
              paramInt1 = 0;
              break label637;
            }
            paramm.iBu.add(r.b.as(0, paramString.bGw));
            if (!paramm.leN)
            {
              ((r.b)paramm.iBu.get(paramm.iBu.size() - 1)).lfg = true;
              paramm.leN = true;
            }
            Object localObject5;
            if ((paramString.type == 4) && (paramString.sZo != null))
            {
              localObject3 = paramString.sZo.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject5 = (aaa)((Iterator)localObject3).next();
                localObject4 = new r.b();
                ((r.b)localObject4).type = 3;
                ((r.b)localObject4).appId = ((aaa)localObject5).sZr.euK;
                ((r.b)localObject4).name = ((aaa)localObject5).sZr.kRZ;
                ((r.b)localObject4).fGK = ((aaa)localObject5).sZr.sPt;
                ((r.b)localObject4).iconUrl = ((aaa)localObject5).sZr.kSy;
                ((r.b)localObject4).lfa = ((aaa)localObject5).sZr.kSa;
                ((r.b)localObject4).lfb = ((aaa)localObject5).sZr.sYW;
                ((r.b)localObject4).actionType = ((aaa)localObject5).sZr.sYX;
                ((r.b)localObject4).lfc = ((aaa)localObject5).sZr.sYY;
                ((r.b)localObject4).lfd = ((aaa)localObject5).sZs;
                ((r.b)localObject4).lfi = new r.c(((aaa)localObject5).sZr.sYX, 4, ((aaa)localObject5).sZr.euK, ((aaa)localObject5).sZr.sYY);
                ((r.b)localObject4).bGm = ((String)localObject1);
                ((r.b)localObject4).lfi.lfk = "3";
                localObject5 = ((r.b)localObject4).lfi;
                paramInt1 = paramm.leI;
                paramm.leI = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 601);
                paramm.iBu.add(localObject4);
              }
            }
            if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.sZk != null))
            {
              localObject3 = paramString.sZk.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject5 = (zt)((Iterator)localObject3).next();
                localObject4 = new r.b();
                ((r.b)localObject4).type = 1;
                ((r.b)localObject4).appId = ((zt)localObject5).euK;
                ((r.b)localObject4).name = ((zt)localObject5).kRZ;
                ((r.b)localObject4).fGK = ((zt)localObject5).sPt;
                ((r.b)localObject4).iconUrl = ((zt)localObject5).kSy;
                ((r.b)localObject4).lfa = ((zt)localObject5).kSa;
                ((r.b)localObject4).lfb = ((zt)localObject5).sYW;
                ((r.b)localObject4).actionType = ((zt)localObject5).sYX;
                ((r.b)localObject4).lfc = ((zt)localObject5).sYY;
                ((r.b)localObject4).lfi = new r.c(((zt)localObject5).sYX, 1, ((zt)localObject5).euK, ((zt)localObject5).sYY);
                ((r.b)localObject4).bGm = ((String)localObject1);
                if (paramString.type == 1)
                {
                  paramm.bGq = true;
                  localObject5 = ((r.b)localObject4).lfi;
                  paramInt1 = paramm.lcn;
                  paramm.lcn = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
                for (;;)
                {
                  ((r.b)localObject4).lfi.lfk = "1";
                  paramm.iBu.add(localObject4);
                  break;
                  if (paramString.type == 2)
                  {
                    paramm.leG = true;
                    localObject5 = ((r.b)localObject4).lfi;
                    paramInt1 = paramm.leH;
                    paramm.leH = (paramInt1 + 1);
                    ((r.c)localObject5).position = (paramInt1 + 1);
                  }
                }
              }
            }
            else if ((paramString.type == 3) && (paramString.sZl != null))
            {
              paramm.kQn = paramString.sZp;
              paramm.leM = paramString.sZq;
              localObject3 = paramString.sZl.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = r.b.a((aab)((Iterator)localObject3).next());
                ((r.b)localObject4).bGm = ((String)localObject1);
                ((r.b)localObject4).lfi.appId = ((r.b)localObject4).appId;
                ((r.b)localObject4).lfi.lfe = ((r.b)localObject4).lfe;
                ((r.b)localObject4).lfi.lff = ((r.b)localObject4).lff;
                ((r.b)localObject4).lfi.lfk = "2";
                localObject5 = ((r.b)localObject4).lfi;
                paramInt1 = paramm.leJ;
                paramm.leJ = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 301);
                paramm.iBu.add(localObject4);
              }
            }
            if ((!bk.bl(paramString.sZm)) && (!bk.bl(paramString.sZn)) && (paramString.type == 1))
            {
              localObject3 = paramString.sZm;
              paramString = paramString.sZn;
              localObject4 = new r.b();
              ((r.b)localObject4).type = 5;
              ((r.b)localObject4).name = ((String)localObject3);
              ((r.b)localObject4).lfi = new r.c(paramString);
              ((r.b)localObject4).lfi.appId = "wx62d9035fd4fd2059";
              ((r.b)localObject4).lfi.lfk = "1";
              ((r.b)localObject4).lfi.position = 300;
              paramm.iBu.add(localObject4);
            }
          }
          paramString = paramm.iBu.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (r.b)paramString.next();
            if (paramm.bGq) {
              ((r.b)localObject1).lfi.bXn = 1403;
            } else if (paramm.leG) {
              ((r.b)localObject1).lfi.bXn = 1404;
            } else {
              ((r.b)localObject1).lfi.bXn = 1405;
            }
          }
          paramm.notifyDataSetChanged();
        }
        nD(2);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    label707:
    label712:
    label718:
    label723:
    label738:
    paramString = ((am)paramm).bGm;
    label1749:
    Object localObject1 = ((zv)((am)paramm).jvQ.ecF.ecN).bGw;
    paramm = ((zv)((am)paramm).jvQ.ecF.ecN).sZf;
    this.lfx.a(paramString, (String)localObject1, paramm);
    nD(5);
  }
  
  public final boolean pB(String paramString)
  {
    if (bk.bl(paramString)) {
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = lfs.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    W(localLinkedList);
    nD(1);
    return true;
  }
  
  public final void pC(String paramString)
  {
    if (this.lfD)
    {
      this.lfD = false;
      return;
    }
    if ((this.lfB != null) && (this.lfB.equals(bk.pm(paramString))))
    {
      y.d("MicroMsg.GameSearchUI", "repeat searchChange");
      return;
    }
    this.lfB = paramString;
    if (bk.bl(paramString))
    {
      while (!this.lfC.isEmpty())
      {
        g.DQ();
        g.DO().dJT.c((m)this.lfC.pop());
      }
      paramString = new am(x.cqJ(), paramString, com.tencent.mm.plugin.game.model.f.aYT());
      g.Dk().a(paramString, 0);
      this.lfC.add(paramString);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = lfs.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    W(localLinkedList);
    nD(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI
 * JD-Core Version:    0.7.0.1
 */