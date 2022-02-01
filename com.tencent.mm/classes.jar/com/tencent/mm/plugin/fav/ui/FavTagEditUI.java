package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.adapter.c;
import com.tencent.mm.plugin.fav.ui.adapter.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FavTagEditUI
  extends MMActivity
{
  private g AiB;
  private List<String> AiC;
  private FavTagPanel AiD;
  private FavTagPanel AiE;
  private ListView AiF;
  private ListView AiG;
  private TextView AiH;
  private c AiI;
  private d AiJ;
  private boolean AiK;
  
  public static void a(g paramg, Collection<String> paramCollection, int paramInt)
  {
    AppMethodBeat.i(106930);
    if (paramg == null)
    {
      AppMethodBeat.o(106930);
      return;
    }
    Log.d("MicroMsg.FavTagEditUI", "mod tags %s", new Object[] { paramCollection });
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramg.field_tagProto.ZBH);
    paramg.field_tagProto.ZBH.clear();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      ((ah)h.az(ah.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      b.p(paramg);
      ((ah)h.az(ah.class)).getFavTagSetMgr().q(localHashSet);
      b.a(paramg, paramInt);
      AppMethodBeat.o(106930);
      return;
      paramg.field_tagProto.ZBH.addAll(paramCollection);
      localHashSet.removeAll(paramCollection);
    }
  }
  
  private void aEj()
  {
    AppMethodBeat.i(106929);
    k.b(getContext(), getString(q.i.favorite_quit_edit_tag_tips), "", getString(q.i.app_alert_exit), getString(q.i.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106912);
        FavTagEditUI.this.finish();
        AppMethodBeat.o(106912);
      }
    }, null);
    AppMethodBeat.o(106929);
  }
  
  private void dRX()
  {
    AppMethodBeat.i(106926);
    if (this.AiK)
    {
      Log.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
      AppMethodBeat.o(106926);
      return;
    }
    if (this.AiB == null)
    {
      if ((this.AiE.getTagCount() <= 0) && (this.AiE.getEditText().length() <= 0))
      {
        if (isOptionMenuEnable(0))
        {
          enableOptionMenu(0, false);
          AppMethodBeat.o(106926);
        }
      }
      else if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(106926);
      }
    }
    else if ((this.AiB.field_tagProto.ZBH.size() != this.AiE.getTagCount()) || (this.AiE.getEditText().length() > 0))
    {
      if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(106926);
      }
    }
    else
    {
      ArrayList localArrayList = this.AiE.getTagList();
      int i = 0;
      while (i < localArrayList.size())
      {
        if (!((String)localArrayList.get(i)).equals(this.AiB.field_tagProto.ZBH.get(i)))
        {
          if (!isOptionMenuEnable(0)) {
            enableOptionMenu(0, true);
          }
          AppMethodBeat.o(106926);
          return;
        }
        i += 1;
      }
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
    }
    AppMethodBeat.o(106926);
  }
  
  public int getLayoutId()
  {
    return q.f.fav_tag_edit_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106925);
    super.onCreate(paramBundle);
    final long l = getIntent().getLongExtra("key_fav_item_id", -1L);
    if (-1L != l) {
      this.AiB = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(l);
    }
    this.AiC = getIntent().getStringArrayListExtra("key_fav_result_list");
    this.AiE = ((FavTagPanel)findViewById(q.e.fav_tag_input_panel));
    this.AiF = ((ListView)findViewById(q.e.tag_panel_list));
    this.AiG = ((ListView)findViewById(q.e.search_tag_list));
    this.AiH = ((TextView)findViewById(q.e.max_size_tips_tv));
    this.AiE.LD(true);
    this.AiE.setTagEditTextBG(q.d.tag_edittext_gb);
    this.AiE.setIsAllowEnterCharacter(true);
    this.AiE.setCallBack(new MMTagPanel.a()
    {
      public final void G(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(106917);
        FavTagEditUI.a(FavTagEditUI.this, paramAnonymousBoolean);
        TextView localTextView = FavTagEditUI.k(FavTagEditUI.this);
        if ((FavTagEditUI.b(FavTagEditUI.this)) && (paramAnonymousInt > 0)) {}
        for (int i = 0;; i = 8)
        {
          localTextView.setVisibility(i);
          FavTagEditUI.k(FavTagEditUI.this).setText(FavTagEditUI.this.getString(q.i.favorite_tag_edit_max_length_tips, new Object[] { Integer.valueOf(paramAnonymousInt) }));
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106917);
          return;
        }
      }
      
      public final void aoT(String paramAnonymousString)
      {
        AppMethodBeat.i(106913);
        FavTagEditUI.d(FavTagEditUI.this).aue(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).auE(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).eg(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106913);
      }
      
      public final void aoU(String paramAnonymousString) {}
      
      public final void aoV(String paramAnonymousString)
      {
        AppMethodBeat.i(106914);
        FavTagEditUI.d(FavTagEditUI.this).aue(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).auE(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).eg(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106914);
      }
      
      public final void aoW(String paramAnonymousString)
      {
        AppMethodBeat.i(106915);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          d locald = FavTagEditUI.h(FavTagEditUI.this);
          locald.Akv.clear();
          locald.oXi.clear();
          locald.xts = Util.nullAs(paramAnonymousString, "");
          Object localObject = ((ah)h.az(ah.class)).getFavTagSetMgr();
          boolean bool = Util.isNullOrNil(paramAnonymousString);
          ArrayList localArrayList = new ArrayList(16);
          localObject = ((l)localObject).AcU.Idn.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Iterator localIterator = ((asg)((Iterator)localObject).next()).ZBF.iterator();
            while (localIterator.hasNext())
            {
              asf localasf = (asf)localIterator.next();
              if ((bool) || (localasf.RWX.contains(paramAnonymousString))) {
                localArrayList.add(localasf.RWX);
              }
            }
          }
          locald.oXi.addAll(localArrayList);
          locald.notifyDataSetChanged();
          FavTagEditUI.i(FavTagEditUI.this).setVisibility(0);
          FavTagEditUI.j(FavTagEditUI.this).setVisibility(8);
        }
        for (;;)
        {
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106915);
          return;
          FavTagEditUI.i(FavTagEditUI.this).setVisibility(8);
          FavTagEditUI.j(FavTagEditUI.this).setVisibility(0);
        }
      }
      
      public final void aoX(String paramAnonymousString)
      {
        AppMethodBeat.i(106916);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          Log.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
          AppMethodBeat.o(106916);
          return;
        }
        FavTagEditUI.d(FavTagEditUI.this).cm(paramAnonymousString, true);
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106916);
      }
      
      public final void dCx() {}
    });
    this.AiE.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106918);
        FavTagEditUI.d(FavTagEditUI.this).iCG();
        FavTagEditUI.this.showVKB();
        AppMethodBeat.o(106918);
      }
    }, 100L);
    Object localObject;
    if (this.AiB != null)
    {
      this.AiE.a(this.AiB.field_tagProto.ZBH, this.AiB.field_tagProto.ZBH);
      this.AiI = new c(getContext())
      {
        public final void auw(String paramAnonymousString)
        {
          AppMethodBeat.i(106919);
          FavTagEditUI.d(FavTagEditUI.this).cm(paramAnonymousString, true);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).eg(paramAnonymousString, true);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106919);
        }
        
        public final void aux(String paramAnonymousString)
        {
          AppMethodBeat.i(106920);
          FavTagEditUI.d(FavTagEditUI.this).aue(paramAnonymousString);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).eg(paramAnonymousString, false);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106920);
        }
      };
      localObject = this.AiI;
      if (this.AiB != null) {
        break label664;
      }
    }
    label664:
    for (paramBundle = null;; paramBundle = this.AiB.field_tagProto.ZBH)
    {
      ((c)localObject).fL(paramBundle);
      if ((this.AiB != null) && (!this.AiB.field_tagProto.ZBG.isEmpty()))
      {
        paramBundle = View.inflate(getContext(), q.f.fav_tag_panel_item, null);
        localObject = (TextView)paramBundle.findViewById(q.e.fav_panel_catalog);
        ((TextView)localObject).setText(getString(q.i.favorite_recommended_tag));
        ((TextView)localObject).setVisibility(0);
        int i = getResources().getDimensionPixelSize(q.c.FavTagPadding);
        this.AiD = ((FavTagPanel)paramBundle.findViewById(q.e.fav_tag_panel));
        this.AiD.setVisibility(0);
        this.AiD.a(this.AiB.field_tagProto.ZBH, this.AiB.field_tagProto.ZBG);
        this.AiD.setBackgroundResource(q.d.list_thicklinecell_bg);
        this.AiD.setPadding(0, 0, 0, i);
        this.AiD.setCallBack(new MMTagPanel.a()
        {
          public final void G(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void aoT(String paramAnonymousString)
          {
            AppMethodBeat.i(106921);
            FavTagEditUI.d(FavTagEditUI.this).aue(paramAnonymousString);
            FavTagEditUI.f(FavTagEditUI.this).auE(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106921);
          }
          
          public final void aoU(String paramAnonymousString)
          {
            AppMethodBeat.i(106922);
            FavTagEditUI.d(FavTagEditUI.this).cm(paramAnonymousString, true);
            FavTagEditUI.f(FavTagEditUI.this).auD(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106922);
          }
          
          public final void aoV(String paramAnonymousString) {}
          
          public final void aoW(String paramAnonymousString) {}
          
          public final void aoX(String paramAnonymousString) {}
          
          public final void dCx() {}
        });
        this.AiF.addHeaderView(paramBundle);
      }
      if (((ah)h.az(ah.class)).getFavTagSetMgr().dQx() > 0) {
        this.AiF.addHeaderView(View.inflate(getContext(), q.f.fav_tag_panel_headerview, null));
      }
      this.AiF.setAdapter(this.AiI);
      this.AiF.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106923);
          FavTagEditUI.d(FavTagEditUI.this).jmH();
          AppMethodBeat.o(106923);
          return false;
        }
      });
      this.AiJ = new d(getContext())
      {
        public final void apU(String paramAnonymousString)
        {
          AppMethodBeat.i(106924);
          FavTagEditUI.d(FavTagEditUI.this).cm(paramAnonymousString, true);
          FavTagEditUI.f(FavTagEditUI.this).auD(paramAnonymousString);
          FavTagEditUI.d(FavTagEditUI.this).jmG();
          FavTagEditUI.d(FavTagEditUI.this).jmH();
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106924);
        }
      };
      this.AiG.setAdapter(this.AiJ);
      this.AiG.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106910);
          FavTagEditUI.d(FavTagEditUI.this).jmH();
          AppMethodBeat.o(106910);
          return false;
        }
      });
      setMMTitle(q.i.favorite_edit_tag_tips);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(106909);
          FavTagEditUI.a(FavTagEditUI.this);
          AppMethodBeat.o(106909);
          return true;
        }
      });
      addTextOptionMenu(0, getString(q.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(106911);
          if (FavTagEditUI.b(FavTagEditUI.this))
          {
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106911);
            return true;
          }
          paramAnonymousMenuItem = FavTagEditUI.d(FavTagEditUI.this).getTagList();
          Object localObject1 = FavTagEditUI.d(FavTagEditUI.this).getEditText().trim();
          if (!Util.isNullOrNil((String)localObject1))
          {
            paramAnonymousMenuItem.remove(localObject1);
            paramAnonymousMenuItem.add(localObject1);
          }
          FavTagEditUI.a(FavTagEditUI.this, ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(l));
          if (FavTagEditUI.e(FavTagEditUI.this) != null)
          {
            FavTagEditUI.a(FavTagEditUI.e(FavTagEditUI.this), paramAnonymousMenuItem, FavTagEditUI.this.getIntent().getIntExtra("key_fav_scene", 1));
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_fav_result_list", paramAnonymousMenuItem);
            FavTagEditUI.this.setResult(-1, (Intent)localObject1);
          }
          for (;;)
          {
            FavTagEditUI.this.finish();
            FavTagEditUI.this.hideVKB();
            AppMethodBeat.o(106911);
            return true;
            localObject1 = new String[paramAnonymousMenuItem.size()];
            Object localObject2 = paramAnonymousMenuItem.iterator();
            int i = 0;
            while (((Iterator)localObject2).hasNext())
            {
              localObject1[i] = ((String)((Iterator)localObject2).next());
              i += 1;
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("key_fav_result_array", (String[])localObject1);
            ((Intent)localObject2).putExtra("key_fav_result_list", paramAnonymousMenuItem);
            FavTagEditUI.this.setResult(-1, (Intent)localObject2);
          }
        }
      }, null, y.b.adEJ);
      dRX();
      ((ah)h.az(ah.class)).getFavTagSetMgr().a(this.AiI);
      if (this.AiB != null) {
        ((ab)h.ax(ab.class)).c(Long.valueOf(this.AiB.field_localId));
      }
      AppMethodBeat.o(106925);
      return;
      if (this.AiC == null) {
        break;
      }
      this.AiE.a(this.AiC, this.AiC);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106927);
    super.onDestroy();
    l locall = ((ah)h.az(ah.class)).getFavTagSetMgr();
    c localc = this.AiI;
    if (localc == null)
    {
      AppMethodBeat.o(106927);
      return;
    }
    locall.djU.remove(localc.toString());
    AppMethodBeat.o(106927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106928);
    if (paramInt == 4)
    {
      aEj();
      AppMethodBeat.o(106928);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(106928);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI
 * JD-Core Version:    0.7.0.1
 */