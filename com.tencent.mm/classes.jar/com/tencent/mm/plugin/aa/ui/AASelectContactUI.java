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
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.z;
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
  private ArrayList<String> iCk;
  private ArrayList<String> iCl;
  private HashSet<String> iCm;
  private HashSet<String> iCn;
  private long iCo;
  private int iCp;
  private CheckBox iCq;
  private View iCr;
  private List<String> iCs;
  private List<String> iCt;
  private int scene;
  private String title;
  
  private void WT()
  {
    AppMethodBeat.i(63544);
    if (this.iCn.size() > 0) {
      updateOptionMenuText(1, getString(2131755030, new Object[] { Integer.valueOf(this.iCn.size()) }));
    }
    while ((this.iCn.size() == 1) && (this.iCn.contains(u.axw())))
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
      updateOptionMenuText(1, getString(2131755835));
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(63544);
  }
  
  private void aH(List<String> paramList)
  {
    AppMethodBeat.i(207000);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (ai.aNc(str)) {
          this.iCt.add(str);
        } else {
          this.iCs.add(str);
        }
      }
    }
    AppMethodBeat.o(207000);
  }
  
  private boolean aOn()
  {
    return this.scene == 6;
  }
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(63545);
    if (paramInt == 1)
    {
      this.iCn.remove(paramString);
      frq().notifyDataSetChanged();
    }
    AppMethodBeat.o(63545);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(63536);
    super.WJ();
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.iCl = getIntent().getStringArrayListExtra("third_party_usernamelist");
    this.title = getIntent().getStringExtra("titile");
    this.iCo = getIntent().getLongExtra("max_select_num", 20L);
    this.iCp = getIntent().getIntExtra("select_type", 1);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!w.sQ(this.chatroomName)) {
      ac.i("MicroMsg.AASelectContactUI", "is single chat");
    }
    this.iCn = new HashSet();
    this.iCm = new HashSet();
    this.iCk = new ArrayList();
    this.iCt = new ArrayList();
    this.iCs = new ArrayList();
    if (w.wr(this.chatroomName)) {
      aH(i.FO(this.chatroomName));
    }
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bs.isNullOrNil(str)) {
      this.iCm.addAll(Arrays.asList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bs.isNullOrNil(str))
    {
      this.iCn.addAll(bs.S(str.split(",")));
      WT();
    }
    this.iCk.addAll(this.iCn);
    this.iCq = ((CheckBox)findViewById(2131305975));
    this.iCr = findViewById(2131305976);
    this.iCr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(63530);
        if (AASelectContactUI.a(AASelectContactUI.this).isChecked()) {
          if (AASelectContactUI.b(AASelectContactUI.this) != null)
          {
            AASelectContactUI.b(AASelectContactUI.this).clear();
            AASelectContactUI.a(AASelectContactUI.this).setChecked(false);
            AASelectContactUI.this.frq().notifyDataSetChanged();
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
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
            if (paramAnonymousView.size() <= AASelectContactUI.g(AASelectContactUI.this)) {
              break label283;
            }
            com.tencent.mm.ui.base.h.a(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131755068, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            if (!w.wr(AASelectContactUI.e(AASelectContactUI.this))) {
              paramAnonymousView = i.FO(AASelectContactUI.e(AASelectContactUI.this));
            } else {
              paramAnonymousView = AASelectContactUI.f(AASelectContactUI.this);
            }
          }
          label283:
          AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
        }
      }
    });
    int i;
    if (aOn())
    {
      i = this.iCl.size();
      if (this.iCn.size() != i) {
        break label409;
      }
      this.iCq.setChecked(true);
    }
    for (;;)
    {
      this.iCq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      if (!w.wr(this.chatroomName))
      {
        i = i.FO(this.chatroomName).size();
        break;
      }
      i = this.iCs.size();
      break;
      label409:
      this.iCq.setChecked(false);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63542);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.iCn.contains(parama.contact.field_username);
      AppMethodBeat.o(63542);
      return bool;
    }
    AppMethodBeat.o(63542);
    return false;
  }
  
  public final boolean aOi()
  {
    return false;
  }
  
  public final boolean aOj()
  {
    return false;
  }
  
  public final String aOk()
  {
    return this.title;
  }
  
  public final q aOl()
  {
    AppMethodBeat.i(63539);
    if (aOn())
    {
      localObject = new d(this, this.iCl);
      AppMethodBeat.o(63539);
      return localObject;
    }
    Object localObject = new e(this, this.chatroomName);
    AppMethodBeat.o(63539);
    return localObject;
  }
  
  public final o aOm()
  {
    AppMethodBeat.i(63540);
    if (aOn())
    {
      localObject = new f(this, this.iCl);
      AppMethodBeat.o(63540);
      return localObject;
    }
    Object localObject = new g(this, this.chatroomName);
    AppMethodBeat.o(63540);
    return localObject;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63543);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.iCm.contains(parama.contact.field_username);
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
        if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
        {
          com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131760646, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
          com.tencent.mm.plugin.report.service.h.wUl.f(13722, new Object[] { Integer.valueOf(3) });
          AppMethodBeat.o(63532);
          return true;
        }
        if (AASelectContactUI.b(AASelectContactUI.this).size() <= 0)
        {
          com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131755071, new Object[] { Integer.valueOf(1) }), "", true);
          com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(9) });
          AppMethodBeat.o(63532);
          return true;
        }
        paramAnonymousMenuItem = new LinkedList();
        paramAnonymousMenuItem.addAll(AASelectContactUI.b(AASelectContactUI.this));
        paramAnonymousMenuItem = bs.n(paramAnonymousMenuItem, ",");
        AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
        AASelectContactUI.this.finish();
        AASelectContactUI.this.hideVKB();
        com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
        AppMethodBeat.o(63532);
        return true;
      }
    }, null, s.b.Hom);
    WT();
    this.uFo.setOnContactDeselectListener(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63535);
        if ((AASelectContactUI.b(AASelectContactUI.this) != null) && (AASelectContactUI.b(AASelectContactUI.this).size() > 0) && (AASelectContactUI.b(AASelectContactUI.this).size() <= AASelectContactUI.g(AASelectContactUI.this)) && ((AASelectContactUI.b(AASelectContactUI.this).size() != 1) || (!AASelectContactUI.b(AASelectContactUI.this).contains(u.axw()))))
        {
          if ((AASelectContactUI.i(AASelectContactUI.this) == null) || (AASelectContactUI.i(AASelectContactUI.this).size() != AASelectContactUI.b(AASelectContactUI.this).size())) {
            break label294;
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
                if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
                {
                  com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131760646, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
                  com.tencent.mm.plugin.report.service.h.wUl.f(13722, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(63533);
                  return;
                }
                paramAnonymous2DialogInterface = new LinkedList();
                paramAnonymous2DialogInterface.addAll(AASelectContactUI.b(AASelectContactUI.this));
                paramAnonymous2DialogInterface = bs.n(paramAnonymous2DialogInterface, ",");
                AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymous2DialogInterface));
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(11) });
                AppMethodBeat.o(63533);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63534);
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(10) });
                AppMethodBeat.o(63534);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(7) });
            AppMethodBeat.o(63535);
            return true;
            AASelectContactUI.this.finish();
            continue;
            AASelectContactUI.this.finish();
          }
        }
      }
    });
    if (w.wr(this.chatroomName))
    {
      View localView = z.jD(getContext()).inflate(2131492890, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131307262);
      ViewGroup.LayoutParams localLayoutParams = localLinearLayout.getLayoutParams();
      localLayoutParams.height = com.tencent.mm.cc.a.fromDPToPix(getContext(), 44);
      localLinearLayout.setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 16), com.tencent.mm.cc.a.fromDPToPix(getContext(), 15), 0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 8));
      localLinearLayout.setLayoutParams(localLayoutParams);
      localView.findViewById(2131307263).setVisibility(0);
      getContentLV().addHeaderView(localView, null, false);
    }
    AppMethodBeat.o(63537);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63538);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("always_select_contact");
    if (!bs.isNullOrNil(paramBundle)) {
      this.iCm.addAll(bs.S(paramBundle.split(",")));
    }
    AppMethodBeat.o(63538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(63541);
    p localp = frq();
    Object localObject = localp.abQ(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(63541);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(63541);
      return;
    }
    ac.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    if (ai.aNc((String)localObject))
    {
      AppMethodBeat.o(63541);
      return;
    }
    if (((String)localObject).equals(u.axw()))
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(4) });
      frx();
      if (!this.iCn.contains(localObject)) {
        break label235;
      }
      this.iCn.remove(localObject);
      label156:
      if (!aOn()) {
        break label247;
      }
      paramInt = this.iCl.size();
      label171:
      if (this.iCn.size() != paramInt) {
        break label286;
      }
      this.iCq.setChecked(true);
    }
    for (;;)
    {
      localp.notifyDataSetChanged();
      WT();
      AppMethodBeat.o(63541);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      break;
      label235:
      this.iCn.add(localObject);
      break label156;
      label247:
      if (!w.wr(this.chatroomName))
      {
        paramInt = i.FO(this.chatroomName).size();
        break label171;
      }
      paramInt = this.iCs.size();
      break label171;
      label286:
      this.iCq.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI
 * JD-Core Version:    0.7.0.1
 */