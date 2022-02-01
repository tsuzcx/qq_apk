package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AASelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private ArrayList<String> icd;
  private ArrayList<String> ice;
  private HashSet<String> icf;
  private HashSet<String> icg;
  private long ich;
  private int ici;
  private CheckBox icj;
  private View ick;
  private int scene;
  private String title;
  
  private void VV()
  {
    AppMethodBeat.i(63544);
    if (this.icg.size() > 0) {
      updateOptionMenuText(1, getString(2131755030, new Object[] { Integer.valueOf(this.icg.size()) }));
    }
    while ((this.icg.size() == 1) && (this.icg.contains(u.aqG())))
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
      updateOptionMenuText(1, getString(2131755835));
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(63544);
  }
  
  private boolean aHy()
  {
    return this.scene == 6;
  }
  
  public final void N(int paramInt, String paramString)
  {
    AppMethodBeat.i(63545);
    if (paramInt == 1)
    {
      this.icg.remove(paramString);
      fbz().notifyDataSetChanged();
    }
    AppMethodBeat.o(63545);
  }
  
  public final void VL()
  {
    AppMethodBeat.i(63536);
    super.VL();
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.ice = getIntent().getStringArrayListExtra("third_party_usernamelist");
    this.title = getIntent().getStringExtra("titile");
    this.ich = getIntent().getLongExtra("max_select_num", 20L);
    this.ici = getIntent().getIntExtra("select_type", 1);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!w.pF(this.chatroomName)) {
      ad.i("MicroMsg.AASelectContactUI", "is single chat");
    }
    this.icg = new HashSet();
    this.icf = new HashSet();
    this.icd = new ArrayList();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bt.isNullOrNil(str)) {
      this.icf.addAll(Arrays.asList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bt.isNullOrNil(str))
    {
      this.icg.addAll(bt.S(str.split(",")));
      VV();
    }
    this.icd.addAll(this.icg);
    this.icj = ((CheckBox)findViewById(2131305975));
    this.ick = findViewById(2131305976);
    this.ick.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(63530);
        if (AASelectContactUI.a(AASelectContactUI.this).isChecked()) {
          if (AASelectContactUI.b(AASelectContactUI.this) != null)
          {
            AASelectContactUI.b(AASelectContactUI.this).clear();
            AASelectContactUI.a(AASelectContactUI.this).setChecked(false);
            AASelectContactUI.this.fbz().notifyDataSetChanged();
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
          AppMethodBeat.o(63530);
          return;
          AASelectContactUI.a(AASelectContactUI.this, new HashSet());
          break;
          if (AASelectContactUI.c(AASelectContactUI.this))
          {
            paramAnonymousView = new ArrayList();
            Iterator localIterator = AASelectContactUI.d(AASelectContactUI.this).iterator();
            while (localIterator.hasNext()) {
              paramAnonymousView.add((String)localIterator.next());
            }
          }
          for (;;)
          {
            if (paramAnonymousView.size() <= AASelectContactUI.f(AASelectContactUI.this)) {
              break label259;
            }
            com.tencent.mm.ui.base.h.a(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131755068, new Object[] { Long.valueOf(AASelectContactUI.f(AASelectContactUI.this)) }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63529);
                AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
                AppMethodBeat.o(63529);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            break;
            paramAnonymousView = i.BL(AASelectContactUI.e(AASelectContactUI.this));
          }
          label259:
          AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
        }
      }
    });
    int i;
    if (aHy())
    {
      i = this.ice.size();
      if (this.icg.size() != i) {
        break label337;
      }
      this.icj.setChecked(true);
    }
    for (;;)
    {
      this.icj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(63531);
          AASelectContactUI.g(AASelectContactUI.this);
          AppMethodBeat.o(63531);
        }
      });
      AppMethodBeat.o(63536);
      return;
      i = i.BL(this.chatroomName).size();
      break;
      label337:
      this.icj.setChecked(false);
    }
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(63542);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.icg.contains(parama.contact.field_username);
      AppMethodBeat.o(63542);
      return bool;
    }
    AppMethodBeat.o(63542);
    return false;
  }
  
  public final boolean aHt()
  {
    return false;
  }
  
  public final boolean aHu()
  {
    return false;
  }
  
  public final String aHv()
  {
    return this.title;
  }
  
  public final q aHw()
  {
    AppMethodBeat.i(63539);
    if (aHy())
    {
      localObject = new d(this, this.ice);
      AppMethodBeat.o(63539);
      return localObject;
    }
    Object localObject = new e(this, this.chatroomName);
    AppMethodBeat.o(63539);
    return localObject;
  }
  
  public final o aHx()
  {
    AppMethodBeat.i(63540);
    if (aHy())
    {
      localObject = new f(this, this.ice);
      AppMethodBeat.o(63540);
      return localObject;
    }
    Object localObject = new g(this, this.chatroomName);
    AppMethodBeat.o(63540);
    return localObject;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(63543);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.icf.contains(parama.contact.field_username);
      AppMethodBeat.o(63543);
      return bool;
    }
    AppMethodBeat.o(63543);
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131492889;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63537);
    super.initView();
    addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63532);
        if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.f(AASelectContactUI.this))
        {
          com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131760646, new Object[] { Long.valueOf(AASelectContactUI.f(AASelectContactUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
          com.tencent.mm.plugin.report.service.h.vKh.f(13722, new Object[] { Integer.valueOf(3) });
          AppMethodBeat.o(63532);
          return true;
        }
        if (AASelectContactUI.b(AASelectContactUI.this).size() <= 0)
        {
          com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131755071, new Object[] { Integer.valueOf(1) }), "", true);
          com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(9) });
          AppMethodBeat.o(63532);
          return true;
        }
        paramAnonymousMenuItem = new LinkedList();
        paramAnonymousMenuItem.addAll(AASelectContactUI.b(AASelectContactUI.this));
        paramAnonymousMenuItem = bt.n(paramAnonymousMenuItem, ",");
        AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
        AASelectContactUI.this.finish();
        AASelectContactUI.this.hideVKB();
        com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
        AppMethodBeat.o(63532);
        return true;
      }
    }, null, r.b.FOB);
    VV();
    this.twW.setOnContactDeselectListener(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63535);
        if ((AASelectContactUI.b(AASelectContactUI.this) != null) && (AASelectContactUI.b(AASelectContactUI.this).size() > 0) && (AASelectContactUI.b(AASelectContactUI.this).size() <= AASelectContactUI.f(AASelectContactUI.this)) && ((AASelectContactUI.b(AASelectContactUI.this).size() != 1) || (!AASelectContactUI.b(AASelectContactUI.this).contains(u.aqG()))))
        {
          if ((AASelectContactUI.h(AASelectContactUI.this) == null) || (AASelectContactUI.h(AASelectContactUI.this).size() != AASelectContactUI.b(AASelectContactUI.this).size())) {
            break label294;
          }
          paramAnonymousMenuItem = AASelectContactUI.b(AASelectContactUI.this).iterator();
          i = 0;
          while (paramAnonymousMenuItem.hasNext())
          {
            String str = (String)paramAnonymousMenuItem.next();
            if (!AASelectContactUI.h(AASelectContactUI.this).contains(str)) {
              break;
            }
            i += 1;
          }
          if (i != AASelectContactUI.b(AASelectContactUI.this).size()) {
            break label294;
          }
        }
        label294:
        for (int i = 0;; i = 1)
        {
          if (i != 0) {
            com.tencent.mm.ui.base.h.a(AASelectContactUI.this, AASelectContactUI.this.getString(2131755066), null, AASelectContactUI.this.getString(2131755070), AASelectContactUI.this.getString(2131755069), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63533);
                if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.f(AASelectContactUI.this))
                {
                  com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131760646, new Object[] { Long.valueOf(AASelectContactUI.f(AASelectContactUI.this)) }), "", true);
                  com.tencent.mm.plugin.report.service.h.vKh.f(13722, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(63533);
                  return;
                }
                paramAnonymous2DialogInterface = new LinkedList();
                paramAnonymous2DialogInterface.addAll(AASelectContactUI.b(AASelectContactUI.this));
                paramAnonymous2DialogInterface = bt.n(paramAnonymous2DialogInterface, ",");
                AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymous2DialogInterface));
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(11) });
                AppMethodBeat.o(63533);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63534);
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(10) });
                AppMethodBeat.o(63534);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(7) });
            AppMethodBeat.o(63535);
            return true;
            AASelectContactUI.this.finish();
            continue;
            AASelectContactUI.this.finish();
          }
        }
      }
    });
    AppMethodBeat.o(63537);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63538);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("always_select_contact");
    if (!bt.isNullOrNil(paramBundle)) {
      this.icf.addAll(bt.S(paramBundle.split(",")));
    }
    AppMethodBeat.o(63538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(63541);
    p localp = fbz();
    Object localObject = localp.ZC(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(63541);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(63541);
      return;
    }
    ad.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    if (((String)localObject).equals(u.aqG()))
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(4) });
      fbG();
      if (!this.icg.contains(localObject)) {
        break label220;
      }
      this.icg.remove(localObject);
      label141:
      if (!aHy()) {
        break label232;
      }
      paramInt = this.ice.size();
      label156:
      if (this.icg.size() != paramInt) {
        break label248;
      }
      this.icj.setChecked(true);
    }
    for (;;)
    {
      localp.notifyDataSetChanged();
      VV();
      AppMethodBeat.o(63541);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      break;
      label220:
      this.icg.add(localObject);
      break label141;
      label232:
      paramInt = i.BL(this.chatroomName).size();
      break label156;
      label248:
      this.icj.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI
 * JD-Core Version:    0.7.0.1
 */