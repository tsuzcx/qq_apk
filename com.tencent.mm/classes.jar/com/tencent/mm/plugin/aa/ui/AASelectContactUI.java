package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.w.b;
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
  private ArrayList<String> mNf;
  private ArrayList<String> mNg;
  private HashSet<String> mNh;
  private HashSet<String> mNi;
  private long mNj;
  private CheckBox mNk;
  private View mNl;
  private List<String> mNm;
  private List<String> mNn;
  private int scene;
  private int selectType;
  private String title;
  
  private void aP(List<String> paramList)
  {
    AppMethodBeat.i(218756);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (as.bvK(str)) {
          this.mNn.add(str);
        } else {
          this.mNm.add(str);
        }
      }
    }
    AppMethodBeat.o(218756);
  }
  
  private void atk()
  {
    AppMethodBeat.i(63544);
    if (this.mNi.size() > 0)
    {
      enableOptionMenu(1, true);
      updateOptionMenuText(1, getString(a.i.aa_confirm_num, new Object[] { Integer.valueOf(this.mNi.size()) }));
    }
    while ((this.mNi.size() == 1) && (this.mNi.contains(z.bcZ())))
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
      enableOptionMenu(1, false);
      updateOptionMenuText(1, getString(a.i.app_ok));
    }
    if (this.mNi.size() == 0)
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(63544);
  }
  
  private boolean bwM()
  {
    return this.scene == 6;
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(218748);
    paramView = hUP();
    Object localObject = paramView.awM(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(218748);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(218748);
      return;
    }
    Log.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    if (as.bvK((String)localObject))
    {
      AppMethodBeat.o(218748);
      return;
    }
    if (((String)localObject).equals(z.bcZ()))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(4) });
      hUZ();
      if (!this.mNi.contains(localObject)) {
        break label228;
      }
      this.mNi.remove(localObject);
      label150:
      if (!bwM()) {
        break label240;
      }
      paramInt = this.mNg.size();
      label165:
      if (this.mNi.size() != paramInt) {
        break label279;
      }
      this.mNk.setChecked(true);
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      atk();
      AppMethodBeat.o(218748);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      break;
      label228:
      this.mNi.add(localObject);
      break label150;
      label240:
      if (!ab.PR(this.chatroomName))
      {
        paramInt = i.aag(this.chatroomName).size();
        break label165;
      }
      paramInt = this.mNm.size();
      break label165;
      label279:
      this.mNk.setChecked(false);
    }
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(63545);
    if (paramInt == 1)
    {
      this.mNi.remove(paramString);
      hUP().notifyDataSetChanged();
    }
    AppMethodBeat.o(63545);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63542);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.mNi.contains(parama.contact.field_username);
      AppMethodBeat.o(63542);
      return bool;
    }
    AppMethodBeat.o(63542);
    return false;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(63536);
    super.ata();
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.mNg = getIntent().getStringArrayListExtra("third_party_usernamelist");
    this.title = getIntent().getStringExtra("titile");
    this.mNj = getIntent().getLongExtra("max_select_num", 20L);
    this.selectType = getIntent().getIntExtra("select_type", 1);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!ab.Lj(this.chatroomName)) {
      Log.i("MicroMsg.AASelectContactUI", "is single chat");
    }
    this.mNi = new HashSet();
    this.mNh = new HashSet();
    this.mNf = new ArrayList();
    this.mNn = new ArrayList();
    this.mNm = new ArrayList();
    if (ab.PR(this.chatroomName)) {
      aP(i.aag(this.chatroomName));
    }
    String str = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.mNh.addAll(Arrays.asList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil(str))
    {
      this.mNi.addAll(Util.stringsToList(str.split(",")));
      atk();
    }
    this.mNf.addAll(this.mNi);
    this.mNk = ((CheckBox)findViewById(a.f.toggle_select_all));
    this.mNl = findViewById(a.f.toggle_select_all_click_area);
    this.mNl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(63530);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/AASelectContactUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        if (AASelectContactUI.a(AASelectContactUI.this).isChecked()) {
          if (AASelectContactUI.b(AASelectContactUI.this) != null)
          {
            AASelectContactUI.b(AASelectContactUI.this).clear();
            AASelectContactUI.a(AASelectContactUI.this).setChecked(false);
            AASelectContactUI.this.hUP().notifyDataSetChanged();
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AASelectContactUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63530);
          return;
          AASelectContactUI.a(AASelectContactUI.this, new HashSet());
          break;
          if (AASelectContactUI.c(AASelectContactUI.this))
          {
            paramAnonymousView = new ArrayList();
            localObject = AASelectContactUI.d(AASelectContactUI.this).iterator();
            while (((Iterator)localObject).hasNext()) {
              paramAnonymousView.add((String)((Iterator)localObject).next());
            }
          }
          for (;;)
          {
            if (paramAnonymousView.size() <= AASelectContactUI.g(AASelectContactUI.this)) {
              break label325;
            }
            com.tencent.mm.ui.base.h.a(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(a.i.aa_select_contact_exceed_alert, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            if (!ab.PR(AASelectContactUI.e(AASelectContactUI.this))) {
              paramAnonymousView = i.aag(AASelectContactUI.e(AASelectContactUI.this));
            } else {
              paramAnonymousView = AASelectContactUI.f(AASelectContactUI.this);
            }
          }
          label325:
          AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
        }
      }
    });
    int i;
    if (bwM())
    {
      i = this.mNg.size();
      if (this.mNi.size() != i) {
        break label416;
      }
      this.mNk.setChecked(true);
    }
    for (;;)
    {
      this.mNk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      if (!ab.PR(this.chatroomName))
      {
        i = i.aag(this.chatroomName).size();
        break;
      }
      i = this.mNm.size();
      break;
      label416:
      this.mNk.setChecked(false);
    }
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63543);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.mNh.contains(parama.contact.field_username);
      AppMethodBeat.o(63543);
      return bool;
    }
    AppMethodBeat.o(63543);
    return false;
  }
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    return this.title;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(63539);
    if (bwM())
    {
      localObject = new d(this, this.mNg);
      AppMethodBeat.o(63539);
      return localObject;
    }
    Object localObject = new e(this, this.chatroomName);
    AppMethodBeat.o(63539);
    return localObject;
  }
  
  public final p bwL()
  {
    AppMethodBeat.i(63540);
    if (bwM())
    {
      localObject = new f(this, this.mNg);
      AppMethodBeat.o(63540);
      return localObject;
    }
    Object localObject = new g(this, this.chatroomName);
    AppMethodBeat.o(63540);
    return localObject;
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
          com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
          com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(3) });
          AppMethodBeat.o(63532);
          return true;
        }
        if (AASelectContactUI.b(AASelectContactUI.this).size() <= 0)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(9) });
          AppMethodBeat.o(63532);
          return true;
        }
        paramAnonymousMenuItem = new LinkedList();
        paramAnonymousMenuItem.addAll(AASelectContactUI.b(AASelectContactUI.this));
        paramAnonymousMenuItem = Util.listToString(paramAnonymousMenuItem, ",");
        AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
        AASelectContactUI.this.finish();
        AASelectContactUI.this.hideVKB();
        com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
        AppMethodBeat.o(63532);
        return true;
      }
    }, null, w.b.Wao);
    atk();
    this.ETP.setOnContactDeselectListener(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63535);
        if ((AASelectContactUI.b(AASelectContactUI.this) != null) && (AASelectContactUI.b(AASelectContactUI.this).size() > 0) && (AASelectContactUI.b(AASelectContactUI.this).size() <= AASelectContactUI.g(AASelectContactUI.this)) && ((AASelectContactUI.b(AASelectContactUI.this).size() != 1) || (!AASelectContactUI.b(AASelectContactUI.this).contains(z.bcZ()))))
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
            com.tencent.mm.ui.base.h.a(AASelectContactUI.this, AASelectContactUI.this.getString(a.i.aa_select_contact_back_confirm), null, AASelectContactUI.this.getString(a.i.aa_select_contact_save), AASelectContactUI.this.getString(a.i.aa_select_contact_not_save), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63533);
                if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
                {
                  com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
                  com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(63533);
                  return;
                }
                paramAnonymous2DialogInterface = new LinkedList();
                paramAnonymous2DialogInterface.addAll(AASelectContactUI.b(AASelectContactUI.this));
                paramAnonymous2DialogInterface = Util.listToString(paramAnonymous2DialogInterface, ",");
                AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymous2DialogInterface));
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(11) });
                AppMethodBeat.o(63533);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63534);
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(10) });
                AppMethodBeat.o(63534);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(7) });
            AppMethodBeat.o(63535);
            return true;
            AASelectContactUI.this.finish();
            continue;
            AASelectContactUI.this.finish();
          }
        }
      }
    });
    if (ab.PR(this.chatroomName))
    {
      View localView = ad.kS(getContext()).inflate(a.g.aa_small_footer, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.aa_small_footer_layout);
      ViewGroup.LayoutParams localLayoutParams = localLinearLayout.getLayoutParams();
      localLayoutParams.height = com.tencent.mm.ci.a.fromDPToPix(getContext(), 44);
      localLinearLayout.setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 16), com.tencent.mm.ci.a.fromDPToPix(getContext(), 15), 0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 8));
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
      this.mNh.addAll(Util.stringsToList(paramBundle.split(",")));
    }
    AppMethodBeat.o(63538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI
 * JD-Core Version:    0.7.0.1
 */