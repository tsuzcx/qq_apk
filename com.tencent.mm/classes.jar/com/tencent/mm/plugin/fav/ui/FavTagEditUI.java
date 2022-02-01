package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
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
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.w.b;
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
  private g wMe;
  private List<String> wMf;
  private FavTagPanel wMg;
  private FavTagPanel wMh;
  private ListView wMi;
  private ListView wMj;
  private TextView wMk;
  private c wMl;
  private d wMm;
  private boolean wMn;
  
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
    localHashSet.addAll(paramg.field_tagProto.SAP);
    paramg.field_tagProto.SAP.clear();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      b.p(paramg);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().j(localHashSet);
      b.a(paramg, paramInt);
      AppMethodBeat.o(106930);
      return;
      paramg.field_tagProto.SAP.addAll(paramCollection);
      localHashSet.removeAll(paramCollection);
    }
  }
  
  private void ack()
  {
    AppMethodBeat.i(106929);
    com.tencent.mm.ui.base.h.c(getContext(), getString(s.i.favorite_quit_edit_tag_tips), "", getString(s.i.app_alert_exit), getString(s.i.app_cancel), new DialogInterface.OnClickListener()
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
  
  private void dlh()
  {
    AppMethodBeat.i(106926);
    if (this.wMn)
    {
      Log.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
      AppMethodBeat.o(106926);
      return;
    }
    if (this.wMe == null)
    {
      if ((this.wMh.getTagCount() <= 0) && (this.wMh.getEditText().length() <= 0))
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
    else if ((this.wMe.field_tagProto.SAP.size() != this.wMh.getTagCount()) || (this.wMh.getEditText().length() > 0))
    {
      if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(106926);
      }
    }
    else
    {
      ArrayList localArrayList = this.wMh.getTagList();
      int i = 0;
      while (i < localArrayList.size())
      {
        if (!((String)localArrayList.get(i)).equals(this.wMe.field_tagProto.SAP.get(i)))
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
    return s.f.fav_tag_edit_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106925);
    super.onCreate(paramBundle);
    final long l = getIntent().getLongExtra("key_fav_item_id", -1L);
    if (-1L != l) {
      this.wMe = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(l);
    }
    this.wMf = getIntent().getStringArrayListExtra("key_fav_result_list");
    this.wMh = ((FavTagPanel)findViewById(s.e.fav_tag_input_panel));
    this.wMi = ((ListView)findViewById(s.e.tag_panel_list));
    this.wMj = ((ListView)findViewById(s.e.search_tag_list));
    this.wMk = ((TextView)findViewById(s.e.max_size_tips_tv));
    this.wMh.FR(true);
    this.wMh.setTagEditTextBG(s.d.tag_edittext_gb);
    this.wMh.setIsAllowEnterCharacter(true);
    this.wMh.setCallBack(new MMTagPanel.a()
    {
      public final void I(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(106917);
        FavTagEditUI.a(FavTagEditUI.this, paramAnonymousBoolean);
        TextView localTextView = FavTagEditUI.k(FavTagEditUI.this);
        if ((FavTagEditUI.b(FavTagEditUI.this)) && (paramAnonymousInt > 0)) {}
        for (int i = 0;; i = 8)
        {
          localTextView.setVisibility(i);
          FavTagEditUI.k(FavTagEditUI.this).setText(FavTagEditUI.this.getString(s.i.favorite_tag_edit_max_length_tips, new Object[] { Integer.valueOf(paramAnonymousInt) }));
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106917);
          return;
        }
      }
      
      public final void auV(String paramAnonymousString)
      {
        AppMethodBeat.i(106913);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).aAw(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).dy(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106913);
      }
      
      public final void auW(String paramAnonymousString) {}
      
      public final void auX(String paramAnonymousString)
      {
        AppMethodBeat.i(106914);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).aAw(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).dy(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106914);
      }
      
      public final void auY(String paramAnonymousString)
      {
        AppMethodBeat.i(106915);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          d locald = FavTagEditUI.h(FavTagEditUI.this);
          locald.wNT.clear();
          locald.wNS.clear();
          locald.una = Util.nullAs(paramAnonymousString, "");
          Object localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr();
          boolean bool = Util.isNullOrNil(paramAnonymousString);
          ArrayList localArrayList = new ArrayList(16);
          localObject = ((l)localObject).wGL.Crg.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Iterator localIterator = ((aon)((Iterator)localObject).next()).SAN.iterator();
            while (localIterator.hasNext())
            {
              aom localaom = (aom)localIterator.next();
              if ((bool) || (localaom.LtE.contains(paramAnonymousString))) {
                localArrayList.add(localaom.LtE);
              }
            }
          }
          locald.wNS.addAll(localArrayList);
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
      
      public final void auZ(String paramAnonymousString)
      {
        AppMethodBeat.i(106916);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          Log.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
          AppMethodBeat.o(106916);
          return;
        }
        FavTagEditUI.d(FavTagEditUI.this).bR(paramAnonymousString, true);
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106916);
      }
      
      public final void cWR() {}
    });
    this.wMh.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106918);
        FavTagEditUI.d(FavTagEditUI.this).hch();
        FavTagEditUI.this.showVKB();
        AppMethodBeat.o(106918);
      }
    }, 100L);
    Object localObject;
    if (this.wMe != null)
    {
      this.wMh.a(this.wMe.field_tagProto.SAP, this.wMe.field_tagProto.SAP);
      this.wMl = new c(getContext())
      {
        public final void aAp(String paramAnonymousString)
        {
          AppMethodBeat.i(106919);
          FavTagEditUI.d(FavTagEditUI.this).bR(paramAnonymousString, true);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).dy(paramAnonymousString, true);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106919);
        }
        
        public final void aAq(String paramAnonymousString)
        {
          AppMethodBeat.i(106920);
          FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).dy(paramAnonymousString, false);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106920);
        }
      };
      localObject = this.wMl;
      if (this.wMe != null) {
        break label633;
      }
    }
    label633:
    for (paramBundle = null;; paramBundle = this.wMe.field_tagProto.SAP)
    {
      ((c)localObject).dQ(paramBundle);
      if ((this.wMe != null) && (!this.wMe.field_tagProto.SAO.isEmpty()))
      {
        paramBundle = View.inflate(getContext(), s.f.fav_tag_panel_item, null);
        localObject = (TextView)paramBundle.findViewById(s.e.fav_panel_catalog);
        ((TextView)localObject).setText(getString(s.i.favorite_recommended_tag));
        ((TextView)localObject).setVisibility(0);
        int i = getResources().getDimensionPixelSize(s.c.FavTagPadding);
        this.wMg = ((FavTagPanel)paramBundle.findViewById(s.e.fav_tag_panel));
        this.wMg.setVisibility(0);
        this.wMg.a(this.wMe.field_tagProto.SAP, this.wMe.field_tagProto.SAO);
        this.wMg.setBackgroundResource(s.d.list_thicklinecell_bg);
        this.wMg.setPadding(0, 0, 0, i);
        this.wMg.setCallBack(new MMTagPanel.a()
        {
          public final void I(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void auV(String paramAnonymousString)
          {
            AppMethodBeat.i(106921);
            FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
            FavTagEditUI.f(FavTagEditUI.this).aAw(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106921);
          }
          
          public final void auW(String paramAnonymousString)
          {
            AppMethodBeat.i(106922);
            FavTagEditUI.d(FavTagEditUI.this).bR(paramAnonymousString, true);
            FavTagEditUI.f(FavTagEditUI.this).aAv(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106922);
          }
          
          public final void auX(String paramAnonymousString) {}
          
          public final void auY(String paramAnonymousString) {}
          
          public final void auZ(String paramAnonymousString) {}
          
          public final void cWR() {}
        });
        this.wMi.addHeaderView(paramBundle);
      }
      if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().djL() > 0) {
        this.wMi.addHeaderView(View.inflate(getContext(), s.f.fav_tag_panel_headerview, null));
      }
      this.wMi.setAdapter(this.wMl);
      this.wMi.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106923);
          FavTagEditUI.d(FavTagEditUI.this).hKb();
          AppMethodBeat.o(106923);
          return false;
        }
      });
      this.wMm = new d(getContext())
      {
        public final void avU(String paramAnonymousString)
        {
          AppMethodBeat.i(106924);
          FavTagEditUI.d(FavTagEditUI.this).bR(paramAnonymousString, true);
          FavTagEditUI.f(FavTagEditUI.this).aAv(paramAnonymousString);
          FavTagEditUI.d(FavTagEditUI.this).hKa();
          FavTagEditUI.d(FavTagEditUI.this).hKb();
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106924);
        }
      };
      this.wMj.setAdapter(this.wMm);
      this.wMj.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106910);
          FavTagEditUI.d(FavTagEditUI.this).hKb();
          AppMethodBeat.o(106910);
          return false;
        }
      });
      setMMTitle(s.i.favorite_edit_tag_tips);
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
      addTextOptionMenu(0, getString(s.i.app_finish), new MenuItem.OnMenuItemClickListener()
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
          FavTagEditUI.a(FavTagEditUI.this, ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(l));
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
      }, null, w.b.Wao);
      dlh();
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().a(this.wMl);
      AppMethodBeat.o(106925);
      return;
      if (this.wMf == null) {
        break;
      }
      this.wMh.a(this.wMf, this.wMf);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106927);
    super.onDestroy();
    l locall = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr();
    c localc = this.wMl;
    if (localc == null)
    {
      AppMethodBeat.o(106927);
      return;
    }
    locall.bqq.remove(localc.toString());
    AppMethodBeat.o(106927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106928);
    if (paramInt == 4)
    {
      ack();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI
 * JD-Core Version:    0.7.0.1
 */