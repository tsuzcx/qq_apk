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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.t.b;
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
  private ArrayList<String> jVS;
  private ArrayList<String> jVT;
  private HashSet<String> jVU;
  private HashSet<String> jVV;
  private long jVW;
  private int jVX;
  private CheckBox jVY;
  private View jVZ;
  private List<String> jWa;
  private List<String> jWb;
  private int scene;
  private String title;
  
  private void aR(List<String> paramList)
  {
    AppMethodBeat.i(213010);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (as.bjp(str)) {
          this.jWb.add(str);
        } else {
          this.jWa.add(str);
        }
      }
    }
    AppMethodBeat.o(213010);
  }
  
  private void ani()
  {
    AppMethodBeat.i(63544);
    if (this.jVV.size() > 0)
    {
      enableOptionMenu(1, true);
      updateOptionMenuText(1, getString(2131755034, new Object[] { Integer.valueOf(this.jVV.size()) }));
    }
    while ((this.jVV.size() == 1) && (this.jVV.contains(z.aTY())))
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
      enableOptionMenu(1, false);
      updateOptionMenuText(1, getString(2131755921));
    }
    if (this.jVV.size() == 0)
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(63544);
      return;
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(63544);
  }
  
  private boolean bmE()
  {
    return this.scene == 6;
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(213009);
    paramView = gUP();
    Object localObject = paramView.anH(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(213009);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(213009);
      return;
    }
    Log.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    if (as.bjp((String)localObject))
    {
      AppMethodBeat.o(213009);
      return;
    }
    if (((String)localObject).equals(z.aTY()))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(4) });
      gUW();
      if (!this.jVV.contains(localObject)) {
        break label228;
      }
      this.jVV.remove(localObject);
      label150:
      if (!bmE()) {
        break label240;
      }
      paramInt = this.jVT.size();
      label165:
      if (this.jVV.size() != paramInt) {
        break label279;
      }
      this.jVY.setChecked(true);
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      ani();
      AppMethodBeat.o(213009);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      break;
      label228:
      this.jVV.add(localObject);
      break label150;
      label240:
      if (!ab.Iz(this.chatroomName))
      {
        paramInt = i.SA(this.chatroomName).size();
        break label165;
      }
      paramInt = this.jWa.size();
      break label165;
      label279:
      this.jVY.setChecked(false);
    }
  }
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(63545);
    if (paramInt == 1)
    {
      this.jVV.remove(paramString);
      gUP().notifyDataSetChanged();
    }
    AppMethodBeat.o(63545);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63542);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.jVV.contains(parama.contact.field_username);
      AppMethodBeat.o(63542);
      return bool;
    }
    AppMethodBeat.o(63542);
    return false;
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(63536);
    super.amZ();
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.jVT = getIntent().getStringArrayListExtra("third_party_usernamelist");
    this.title = getIntent().getStringExtra("titile");
    this.jVW = getIntent().getLongExtra("max_select_num", 20L);
    this.jVX = getIntent().getIntExtra("select_type", 1);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!ab.Eq(this.chatroomName)) {
      Log.i("MicroMsg.AASelectContactUI", "is single chat");
    }
    this.jVV = new HashSet();
    this.jVU = new HashSet();
    this.jVS = new ArrayList();
    this.jWb = new ArrayList();
    this.jWa = new ArrayList();
    if (ab.Iz(this.chatroomName)) {
      aR(i.SA(this.chatroomName));
    }
    String str = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.jVU.addAll(Arrays.asList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil(str))
    {
      this.jVV.addAll(Util.stringsToList(str.split(",")));
      ani();
    }
    this.jVS.addAll(this.jVV);
    this.jVY = ((CheckBox)findViewById(2131309279));
    this.jVZ = findViewById(2131309280);
    this.jVZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(63530);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/AASelectContactUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (AASelectContactUI.a(AASelectContactUI.this).isChecked()) {
          if (AASelectContactUI.b(AASelectContactUI.this) != null)
          {
            AASelectContactUI.b(AASelectContactUI.this).clear();
            AASelectContactUI.a(AASelectContactUI.this).setChecked(false);
            AASelectContactUI.this.gUP().notifyDataSetChanged();
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
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
              break label324;
            }
            com.tencent.mm.ui.base.h.a(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131755079, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            if (!ab.Iz(AASelectContactUI.e(AASelectContactUI.this))) {
              paramAnonymousView = i.SA(AASelectContactUI.e(AASelectContactUI.this));
            } else {
              paramAnonymousView = AASelectContactUI.f(AASelectContactUI.this);
            }
          }
          label324:
          AASelectContactUI.a(AASelectContactUI.this, paramAnonymousView);
        }
      }
    });
    int i;
    if (bmE())
    {
      i = this.jVT.size();
      if (this.jVV.size() != i) {
        break label416;
      }
      this.jVY.setChecked(true);
    }
    for (;;)
    {
      this.jVY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      if (!ab.Iz(this.chatroomName))
      {
        i = i.SA(this.chatroomName).size();
        break;
      }
      i = this.jWa.size();
      break;
      label416:
      this.jVY.setChecked(false);
    }
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(63543);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.jVU.contains(parama.contact.field_username);
      AppMethodBeat.o(63543);
      return bool;
    }
    AppMethodBeat.o(63543);
    return false;
  }
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    return this.title;
  }
  
  public final q bmC()
  {
    AppMethodBeat.i(63539);
    if (bmE())
    {
      localObject = new d(this, this.jVT);
      AppMethodBeat.o(63539);
      return localObject;
    }
    Object localObject = new e(this, this.chatroomName);
    AppMethodBeat.o(63539);
    return localObject;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(63540);
    if (bmE())
    {
      localObject = new f(this, this.jVT);
      AppMethodBeat.o(63540);
      return localObject;
    }
    Object localObject = new g(this, this.chatroomName);
    AppMethodBeat.o(63540);
    return localObject;
  }
  
  public final boolean bmz()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131492906;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63537);
    super.initView();
    addTextOptionMenu(1, getString(2131755921), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63532);
        if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
        {
          com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131762164, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
          com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(3) });
          AppMethodBeat.o(63532);
          return true;
        }
        if (AASelectContactUI.b(AASelectContactUI.this).size() <= 0)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(9) });
          AppMethodBeat.o(63532);
          return true;
        }
        paramAnonymousMenuItem = new LinkedList();
        paramAnonymousMenuItem.addAll(AASelectContactUI.b(AASelectContactUI.this));
        paramAnonymousMenuItem = Util.listToString(paramAnonymousMenuItem, ",");
        AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
        AASelectContactUI.this.finish();
        AASelectContactUI.this.hideVKB();
        com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
        AppMethodBeat.o(63532);
        return true;
      }
    }, null, t.b.OGU);
    ani();
    this.zoy.setOnContactDeselectListener(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63535);
        if ((AASelectContactUI.b(AASelectContactUI.this) != null) && (AASelectContactUI.b(AASelectContactUI.this).size() > 0) && (AASelectContactUI.b(AASelectContactUI.this).size() <= AASelectContactUI.g(AASelectContactUI.this)) && ((AASelectContactUI.b(AASelectContactUI.this).size() != 1) || (!AASelectContactUI.b(AASelectContactUI.this).contains(z.aTY()))))
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
            com.tencent.mm.ui.base.h.a(AASelectContactUI.this, AASelectContactUI.this.getString(2131755077), null, AASelectContactUI.this.getString(2131755081), AASelectContactUI.this.getString(2131755080), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63533);
                if (AASelectContactUI.b(AASelectContactUI.this).size() > AASelectContactUI.g(AASelectContactUI.this))
                {
                  com.tencent.mm.ui.base.h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(2131762164, new Object[] { Long.valueOf(AASelectContactUI.g(AASelectContactUI.this)) }), "", true);
                  com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(63533);
                  return;
                }
                paramAnonymous2DialogInterface = new LinkedList();
                paramAnonymous2DialogInterface.addAll(AASelectContactUI.b(AASelectContactUI.this));
                paramAnonymous2DialogInterface = Util.listToString(paramAnonymous2DialogInterface, ",");
                AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymous2DialogInterface));
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(11) });
                AppMethodBeat.o(63533);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63534);
                AASelectContactUI.this.finish();
                com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(10) });
                AppMethodBeat.o(63534);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(7) });
            AppMethodBeat.o(63535);
            return true;
            AASelectContactUI.this.finish();
            continue;
            AASelectContactUI.this.finish();
          }
        }
      }
    });
    if (ab.Iz(this.chatroomName))
    {
      View localView = aa.jQ(getContext()).inflate(2131492907, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131296313);
      ViewGroup.LayoutParams localLayoutParams = localLinearLayout.getLayoutParams();
      localLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 44);
      localLinearLayout.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16), com.tencent.mm.cb.a.fromDPToPix(getContext(), 15), 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 8));
      localLinearLayout.setLayoutParams(localLayoutParams);
      localView.findViewById(2131296314).setVisibility(0);
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
      this.jVU.addAll(Util.stringsToList(paramBundle.split(",")));
    }
    AppMethodBeat.o(63538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI
 * JD-Core Version:    0.7.0.1
 */