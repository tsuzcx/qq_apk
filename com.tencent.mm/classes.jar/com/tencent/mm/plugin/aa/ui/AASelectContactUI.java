package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.y.b;
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
  private ArrayList<String> pJN;
  private ArrayList<String> pJO;
  private HashSet<String> pJP;
  private HashSet<String> pJQ;
  private long pJR;
  private CheckBox pJS;
  private View pJT;
  private List<String> pJU;
  private List<String> pJV;
  private int scene;
  private int selectType;
  private String title;
  
  private void aNr()
  {
    AppMethodBeat.i(63544);
    if (this.pJQ.size() > 0)
    {
      enableOptionMenu(1, true);
      updateOptionMenuText(1, getString(a.i.aa_confirm_num, new Object[] { Integer.valueOf(this.pJQ.size()) }));
    }
    while ((this.pJQ.size() == 1) && (this.pJQ.contains(z.bAM())))
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
      enableOptionMenu(1, false);
      updateOptionMenuText(1, getString(a.i.app_ok));
    }
    if (this.pJQ.size() == 0)
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(63544);
  }
  
  private boolean bVC()
  {
    return this.scene == 6;
  }
  
  private void cu(List<String> paramList)
  {
    AppMethodBeat.i(268459);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (au.bwO(str)) {
          this.pJV.add(str);
        } else {
          this.pJU.add(str);
        }
      }
    }
    AppMethodBeat.o(268459);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(268530);
    paramAdapterView = jyE();
    paramView = paramAdapterView.aDt(paramInt - getContentLV().getHeaderViewsCount());
    if (paramView == null)
    {
      AppMethodBeat.o(268530);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(268530);
      return;
    }
    Log.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[] { paramView.contact.field_username });
    paramView = paramView.contact.field_username;
    if (au.bwO(paramView))
    {
      AppMethodBeat.o(268530);
      return;
    }
    if (paramView.equals(z.bAM()))
    {
      h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(4) });
      iKA();
      if (!this.pJQ.contains(paramView)) {
        break label228;
      }
      this.pJQ.remove(paramView);
      label150:
      if (!bVC()) {
        break label240;
      }
      paramInt = this.pJO.size();
      label165:
      if (this.pJQ.size() != paramInt) {
        break label279;
      }
      this.pJS.setChecked(true);
    }
    for (;;)
    {
      paramAdapterView.notifyDataSetChanged();
      aNr();
      AppMethodBeat.o(268530);
      return;
      h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      break;
      label228:
      this.pJQ.add(paramView);
      break label150;
      label240:
      if (!ab.IG(this.chatroomName))
      {
        paramInt = j.SA(this.chatroomName).size();
        break label165;
      }
      paramInt = this.pJU.size();
      break label165;
      label279:
      this.pJS.setChecked(false);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63542);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.pJQ.contains(parama.contact.field_username);
      AppMethodBeat.o(63542);
      return bool;
    }
    AppMethodBeat.o(63542);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(63536);
    super.aNi();
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.pJO = getIntent().getStringArrayListExtra("third_party_usernamelist");
    this.title = getIntent().getStringExtra("titile");
    this.pJR = getIntent().getLongExtra("max_select_num", 20L);
    this.selectType = getIntent().getIntExtra("select_type", 1);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!au.bwE(this.chatroomName)) {
      Log.i("MicroMsg.AASelectContactUI", "is single chat");
    }
    this.pJQ = new HashSet();
    this.pJP = new HashSet();
    this.pJN = new ArrayList();
    this.pJV = new ArrayList();
    this.pJU = new ArrayList();
    if (ab.IG(this.chatroomName)) {
      cu(j.SA(this.chatroomName));
    }
    String str = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.pJP.addAll(Arrays.asList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil(str))
    {
      this.pJQ.addAll(Util.stringsToList(str.split(",")));
      aNr();
    }
    this.pJN.addAll(this.pJQ);
    this.pJS = ((CheckBox)findViewById(a.f.toggle_select_all));
    this.pJT = findViewById(a.f.toggle_select_all_click_area);
    this.pJT.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(final View paramAnonymousView)
      {
        AppMethodBeat.i(268581);
        if (AASelectContactUI.a(AASelectContactUI.this).isChecked()) {
          if (AASelectContactUI.b(AASelectContactUI.this) != null)
          {
            AASelectContactUI.b(AASelectContactUI.this).clear();
            AASelectContactUI.a(AASelectContactUI.this).setChecked(false);
            AASelectContactUI.this.jyE().notifyDataSetChanged();
          }
        }
        for (;;)
        {
          h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
          AppMethodBeat.o(268581);
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
            if (paramAnonymousView.size() <= AASelectContactUI.g(AASelectContactUI.this)) {
              break label284;
            }
            com.tencent.mm.ui.base.k.a(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(a.i.aa_select_contact_exceed_alert, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            if (!ab.IG(AASelectContactUI.e(AASelectContactUI.this))) {
              paramAnonymousView = j.SA(AASelectContactUI.e(AASelectContactUI.this));
            } else {
              paramAnonymousView = AASelectContactUI.f(AASelectContactUI.this);
            }
          }
          label284:
          AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
        }
      }
    });
    int i;
    if (bVC())
    {
      i = this.pJO.size();
      if (this.pJQ.size() != i) {
        break label416;
      }
      this.pJS.setChecked(true);
    }
    for (;;)
    {
      this.pJS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(63531);
          AASelectContactUI.h(AASelectContactUI.this);
          AppMethodBeat.o(63531);
        }
      });
      AppMethodBeat.o(63536);
      return;
      if (!ab.IG(this.chatroomName))
      {
        i = j.SA(this.chatroomName).size();
        break;
      }
      i = this.pJU.size();
      break;
      label416:
      this.pJS.setChecked(false);
    }
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(63545);
    if (paramInt == 1)
    {
      this.pJQ.remove(paramString);
      jyE().notifyDataSetChanged();
    }
    AppMethodBeat.o(63545);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63543);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.pJP.contains(parama.contact.field_username);
      AppMethodBeat.o(63543);
      return bool;
    }
    AppMethodBeat.o(63543);
    return false;
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(63539);
    if (bVC())
    {
      localObject = new d(this, this.pJO);
      AppMethodBeat.o(63539);
      return localObject;
    }
    Object localObject = new e(this, this.chatroomName);
    AppMethodBeat.o(63539);
    return localObject;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(63540);
    if (bVC())
    {
      localObject = new f(this, this.pJO);
      AppMethodBeat.o(63540);
      return localObject;
    }
    Object localObject = new g(this, this.chatroomName);
    AppMethodBeat.o(63540);
    return localObject;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
  {
    return this.title;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.aa_select_contact_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63537);
    super.initView();
    addTextOptionMenu(1, getString(a.i.app_ok), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63532);
        if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
        {
          com.tencent.mm.ui.base.k.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
          h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
          h.OAn.b(13722, new Object[] { Integer.valueOf(3) });
          AppMethodBeat.o(63532);
          return true;
        }
        if (AASelectContactUI.b(AASelectContactUI.this).size() <= 0)
        {
          h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(9) });
          AppMethodBeat.o(63532);
          return true;
        }
        paramAnonymousMenuItem = new LinkedList();
        paramAnonymousMenuItem.addAll(AASelectContactUI.b(AASelectContactUI.this));
        paramAnonymousMenuItem = Util.listToString(paramAnonymousMenuItem, ",");
        AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
        AASelectContactUI.this.finish();
        AASelectContactUI.this.hideVKB();
        h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
        AppMethodBeat.o(63532);
        return true;
      }
    }, null, y.b.adEJ);
    aNr();
    this.KOt.setOnContactDeselectListener(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63535);
        if ((AASelectContactUI.b(AASelectContactUI.this) != null) && (AASelectContactUI.b(AASelectContactUI.this).size() > 0) && (AASelectContactUI.b(AASelectContactUI.this).size() <= AASelectContactUI.g(AASelectContactUI.this)) && ((AASelectContactUI.b(AASelectContactUI.this).size() != 1) || (!AASelectContactUI.b(AASelectContactUI.this).contains(z.bAM()))))
        {
          if ((AASelectContactUI.i(AASelectContactUI.this) == null) || (AASelectContactUI.i(AASelectContactUI.this).size() != AASelectContactUI.b(AASelectContactUI.this).size())) {
            break label297;
          }
          paramAnonymousMenuItem = AASelectContactUI.b(AASelectContactUI.this).iterator();
          i = 0;
          while (paramAnonymousMenuItem.hasNext())
          {
            String str = (String)paramAnonymousMenuItem.next();
            if (!AASelectContactUI.i(AASelectContactUI.this).contains(str)) {
              break;
            }
            i += 1;
          }
          if (i != AASelectContactUI.b(AASelectContactUI.this).size()) {
            break label297;
          }
        }
        label297:
        for (int i = 0;; i = 1)
        {
          if (i != 0) {
            com.tencent.mm.ui.base.k.a(AASelectContactUI.this, AASelectContactUI.this.getString(a.i.aa_select_contact_back_confirm), null, AASelectContactUI.this.getString(a.i.aa_select_contact_save), AASelectContactUI.this.getString(a.i.aa_select_contact_not_save), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63533);
                if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
                {
                  com.tencent.mm.ui.base.k.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
                  h.OAn.b(13722, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(63533);
                  return;
                }
                paramAnonymous2DialogInterface = new LinkedList();
                paramAnonymous2DialogInterface.addAll(AASelectContactUI.b(AASelectContactUI.this));
                paramAnonymous2DialogInterface = Util.listToString(paramAnonymous2DialogInterface, ",");
                AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymous2DialogInterface));
                AASelectContactUI.this.finish();
                h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(11) });
                AppMethodBeat.o(63533);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63534);
                AASelectContactUI.this.finish();
                h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(10) });
                AppMethodBeat.o(63534);
              }
            });
          }
          for (;;)
          {
            h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(7) });
            AppMethodBeat.o(63535);
            return true;
            AASelectContactUI.this.finish();
            continue;
            AASelectContactUI.this.finish();
          }
        }
      }
    });
    if (ab.IG(this.chatroomName))
    {
      View localView = af.mU(getContext()).inflate(a.g.aa_small_footer, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.aa_small_footer_layout);
      ViewGroup.LayoutParams localLayoutParams = localLinearLayout.getLayoutParams();
      localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(getContext(), 44);
      localLinearLayout.setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 16), com.tencent.mm.cd.a.fromDPToPix(getContext(), 15), 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 8));
      localLinearLayout.setLayoutParams(localLayoutParams);
      localView.findViewById(a.f.aa_small_tips).setVisibility(0);
      getContentLV().addHeaderView(localView, null, false);
    }
    AppMethodBeat.o(63537);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63538);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil(paramBundle)) {
      this.pJP.addAll(Util.stringsToList(paramBundle.split(",")));
    }
    getContentView().post(new AASelectContactUI.5(this));
    AppMethodBeat.o(63538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(268510);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.aa.model.a.class);
    AppMethodBeat.o(268510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI
 * JD-Core Version:    0.7.0.1
 */