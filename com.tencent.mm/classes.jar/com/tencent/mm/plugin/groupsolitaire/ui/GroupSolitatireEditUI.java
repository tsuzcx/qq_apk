package com.tencent.mm.plugin.groupsolitaire.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.plugin.groupsolitaire.b.e;
import com.tencent.mm.plugin.groupsolitaire.b.f;
import com.tencent.mm.plugin.groupsolitaire.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GroupSolitatireEditUI
  extends MMActivity
  implements com.tencent.mm.ui.tools.h
{
  private boolean BSf;
  private RelativeLayout DpU;
  private CdnImageView DpV;
  private MMEditText DpW;
  private View DpX;
  private View DpY;
  private LinearLayout DpZ;
  private ImageButton Dqa;
  private MMEditText Dqb;
  private LinearLayout Dqc;
  private RelativeLayout Dqd;
  private RelativeLayout Dqe;
  private RelativeLayout Dqf;
  private View Dqg;
  private boolean Dqh;
  private int Dqi;
  private int Dqj;
  private com.tencent.mm.plugin.groupsolitaire.c.a Dqk;
  private com.tencent.mm.plugin.groupsolitaire.c.a Dql;
  private String Dqm;
  private boolean Dqn;
  private boolean Dqo;
  private boolean Dqp;
  private ArrayList<View> Dqq;
  private Rect Dqr;
  private Rect Dqs;
  private a Dqt;
  private View.OnTouchListener Dqu;
  private GestureDetector aHB;
  private boolean ftt;
  private ah iXp;
  private i jij;
  private TextView mMA;
  private ScrollView mPe;
  private View mPf;
  private int scene;
  private TextWatcher uY;
  private boolean wNB;
  
  public GroupSolitatireEditUI()
  {
    AppMethodBeat.i(110460);
    this.Dqh = false;
    this.Dqk = null;
    this.Dql = null;
    this.Dqm = "";
    this.Dqn = false;
    this.BSf = false;
    this.wNB = false;
    this.Dqo = false;
    this.Dqp = false;
    this.Dqq = new ArrayList();
    this.ftt = false;
    this.uY = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(110427);
        long l = System.currentTimeMillis();
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) {
          localObject1 = paramAnonymousEditable.toString();
        }
        try
        {
          String str = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.a.class)).atQ((String)localObject1);
          localObject1 = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            int j;
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
            continue;
            Object localObject2 = localObject1;
            if (j > com.tencent.mm.plugin.groupsolitaire.b.b.eBn() * 2)
            {
              i = com.tencent.mm.plugin.groupsolitaire.b.b.eL((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.eBn() * 2);
              paramAnonymousEditable.delete(i, paramAnonymousEditable.length());
              localObject2 = ((String)localObject1).substring(0, i);
            }
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).header = ((String)localObject2);
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).DpE = 1;
            continue;
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).DpD = ((String)localObject1);
            continue;
            com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(b.e.Don);
            if (localb != null)
            {
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.eBm() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.eL((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.eBm() * 2);
                paramAnonymousEditable.delete(i, paramAnonymousEditable.length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              localb.content = ((String)localObject2);
              continue;
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.eBo() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.eL((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.eBo() * 2);
                paramAnonymousEditable.delete(i, paramAnonymousEditable.length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).CBX = ((String)localObject2);
            }
          }
        }
        i = ((Integer)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(b.e.Dop)).intValue();
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() str:%s type:%s", new Object[] { localObject1, Integer.valueOf(i) });
        j = com.tencent.mm.plugin.groupsolitaire.b.b.aKZ((String)localObject1);
        switch (i)
        {
        default: 
          GroupSolitatireEditUI.d(GroupSolitatireEditUI.this);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110426);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(110426);
            }
          }, 100L);
          Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "startTime:%s interTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(110427);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.Dqu = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110438);
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (GroupSolitatireEditUI.f(GroupSolitatireEditUI.this))) {
          ((MMEditText)paramAnonymousView).setCursorVisible(true);
        }
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (((Integer)((MMEditText)paramAnonymousView).getTag(b.e.Dop)).intValue() == 3) && (GroupSolitatireEditUI.g(GroupSolitatireEditUI.this))) {
          ((MMEditText)paramAnonymousView).setCursorVisible(true);
        }
        if (GroupSolitatireEditUI.d((MMEditText)paramAnonymousView))
        {
          paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this, true);
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            GroupSolitatireEditUI.b(GroupSolitatireEditUI.this, false);
            paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(false);
          }
        }
        AppMethodBeat.o(110438);
        return false;
      }
    };
    AppMethodBeat.o(110460);
  }
  
  private String Ky(String paramString)
  {
    AppMethodBeat.i(110473);
    if (this.iXp == null)
    {
      AppMethodBeat.o(110473);
      return null;
    }
    paramString = this.iXp.PJ(paramString);
    AppMethodBeat.o(110473);
    return paramString;
  }
  
  private void aLe(String paramString)
  {
    AppMethodBeat.i(110481);
    ((MMEditText)this.Dqg).requestFocus();
    this.DpZ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110443);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110443);
      }
    }, 200L);
    ((MMEditText)this.Dqg).getText().insert(this.Dqj, paramString + "; ");
    AppMethodBeat.o(110481);
  }
  
  private void ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.wNB = paramBoolean1;
    }
  }
  
  private boolean asJ()
  {
    AppMethodBeat.i(110464);
    if (this.wNB) {
      com.tencent.mm.ui.base.h.a(this, getString(b.g.DoM), "", getString(b.g.DoL), getString(b.g.DoK), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110429);
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot ok");
          ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          com.tencent.mm.plugin.groupsolitaire.b.d.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this), GroupSolitatireEditUI.o(GroupSolitatireEditUI.this), 2, GroupSolitatireEditUI.f(GroupSolitatireEditUI.this));
          GroupSolitatireEditUI.this.finish();
          AppMethodBeat.o(110429);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110430);
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot cancel");
          AppMethodBeat.o(110430);
        }
      }, b.b.red);
    }
    for (;;)
    {
      AppMethodBeat.o(110464);
      return true;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.Dqk, eBv(), 1, this.Dqn);
      finish();
    }
  }
  
  private void b(final MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110483);
    paramMMEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(246612);
        if ((paramAnonymousBoolean) && (GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) != null) && (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)))
        {
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(246375);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
              AppMethodBeat.o(246375);
            }
          }, 200L);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(246329);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(246329);
            }
          }, 200L);
          AppMethodBeat.o(246612);
          return;
        }
        paramMMEditText.setSelection(0);
        AppMethodBeat.o(246612);
      }
    });
    AppMethodBeat.o(110483);
  }
  
  private CharSequence bP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110472);
    com.tencent.mm.kernel.h.aHH();
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if ((paramBoolean) && (!Util.isNullOrNil(localas.field_conRemark))) {}
    for (String str = localas.field_conRemark;; str = Ky(localas.field_username))
    {
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = localas.field_conRemark;
      }
      str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = localas.ayr();
      }
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = localas.field_username;
      }
      paramString = l.c(getContext(), paramString);
      AppMethodBeat.o(110472);
      return paramString;
    }
  }
  
  private int c(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110484);
    if (this.Dqi == 0)
    {
      AppMethodBeat.o(110484);
      return 10;
    }
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
    float f = paramMMEditText.getLineHeight();
    i = (int)((i - (this.Dqi + this.Dqc.getHeight() + aw.fromDPToPix(this, 145))) / f);
    AppMethodBeat.o(110484);
    return i;
  }
  
  private void eBA()
  {
    AppMethodBeat.i(110480);
    if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_FINE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.sdk.b.a.b(this, getResources().getString(b.g.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
          AppMethodBeat.o(110480);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
        AppMethodBeat.o(110480);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(110480);
        return;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideExitAnimation", com.tencent.mm.plugin.groupsolitaire.b.a.push_down_out);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", com.tencent.mm.plugin.groupsolitaire.b.a.fast_faded_in);
    localIntent.putExtra("map_view_type", 3);
    com.tencent.mm.by.c.b(this, "location", ".ui.RedirectUI", localIntent, 4097);
    AppMethodBeat.o(110480);
  }
  
  private void eBB()
  {
    AppMethodBeat.i(110482);
    if (this.DpU.findFocus() == null)
    {
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "mRootContainer.findFocus() is null");
      AppMethodBeat.o(110482);
      return;
    }
    this.Dqg = this.DpU.findFocus();
    this.Dqj = ((MMEditText)this.Dqg).getSelectionStart();
    AppMethodBeat.o(110482);
  }
  
  private int eBv()
  {
    AppMethodBeat.i(110465);
    if (eBw())
    {
      AppMethodBeat.o(110465);
      return 3;
    }
    int i = this.scene;
    AppMethodBeat.o(110465);
    return i;
  }
  
  private boolean eBw()
  {
    return (this.scene == 3) || (this.scene == 4);
  }
  
  private boolean eBx()
  {
    return (this.scene == 4) || (this.scene == 5);
  }
  
  private void eBy()
  {
    AppMethodBeat.i(110466);
    int j = 1;
    int i = 1;
    MMEditText localMMEditText;
    if (j <= this.Dqk.DpG.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.Dqk.DpG.get(Integer.valueOf(j));
      if (localb == null) {
        break label287;
      }
      View localView = getLayoutInflater().inflate(b.f.DoD, null);
      ((TextView)localView.findViewById(b.e.Doj)).setText(String.valueOf(i));
      localMMEditText = (MMEditText)localView.findViewById(b.e.Doi);
      localMMEditText.setTag(b.e.Dop, Integer.valueOf(3));
      localMMEditText.setTag(b.e.Don, localb);
      localMMEditText.setText(l.d(localMMEditText.getContext(), localb.content, (int)localMMEditText.getTextSize()));
      if (Util.isEqual(localb.username, z.bcZ()))
      {
        this.Dqp = true;
        localMMEditText.requestFocus();
        localMMEditText.setFocusable(true);
        localMMEditText.setFocusableInTouchMode(true);
        localMMEditText.addTextChangedListener(this.uY);
        if (this.scene == 1) {
          localMMEditText.setCursorVisible(false);
        }
        label193:
        localMMEditText.setOnTouchListener(this.Dqu);
        localMMEditText.setMaxLines(10);
        this.DpZ.addView(localView);
        this.Dqq.add(localView);
        b(localMMEditText);
        i += 1;
      }
    }
    label287:
    for (;;)
    {
      j += 1;
      break;
      this.Dqp = false;
      localMMEditText.setTextColor(getResources().getColor(b.b.BW_50));
      localMMEditText.setKeyListener(null);
      localMMEditText.setTextIsSelectable(true);
      break label193;
      AppMethodBeat.o(110466);
      return;
    }
  }
  
  private Pair<Boolean, Boolean> eBz()
  {
    boolean bool4 = false;
    AppMethodBeat.i(246575);
    Object localObject1 = new HashSet();
    int i = 1;
    while (i <= this.Dql.DpG.size())
    {
      localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)this.Dql.DpG.get(Integer.valueOf(i));
      if (Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).username, z.bcZ())) {
        ((Set)localObject1).add(localObject2);
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    HashSet localHashSet = new HashSet();
    i = 1;
    while (i <= this.Dqk.DpG.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.Dqk.DpG.get(Integer.valueOf(i));
      if ((Util.isEqual(localb.username, z.bcZ())) && (!Util.isNullOrNil(localb.content.trim())))
      {
        ((ArrayList)localObject2).add(localb);
        localHashSet.add(localb);
      }
      i += 1;
    }
    boolean bool1;
    boolean bool3;
    boolean bool2;
    if (((Set)localObject1).size() == ((ArrayList)localObject2).size()) {
      if (((ArrayList)localObject2).size() != localHashSet.size())
      {
        bool1 = true;
        localObject2 = ((ArrayList)localObject2).iterator();
        do
        {
          bool3 = bool1;
          bool2 = bool4;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (((Set)localObject1).contains((com.tencent.mm.plugin.groupsolitaire.c.b)((Iterator)localObject2).next()));
      }
    }
    for (;;)
    {
      bool2 = true;
      bool3 = bool1;
      localObject1 = new Pair(Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      AppMethodBeat.o(246575);
      return localObject1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void sA(boolean paramBoolean)
  {
    AppMethodBeat.i(110475);
    int i = 1;
    Object localObject;
    if (i <= this.Dqk.DpG.size())
    {
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)this.Dqk.DpG.get(Integer.valueOf(i));
      if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content.trim()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (this.Dqn)
      {
        if (i != 0)
        {
          enableOptionMenu(0, true);
          if (paramBoolean) {
            break label317;
          }
          if ((this.Dql != null) && (Util.isEqual(this.Dqk.header, this.Dql.header)) && (Util.isEqual(this.Dqk.DpD, this.Dql.DpD)) && (Util.isEqual(this.Dqk.CBX, this.Dql.CBX)))
          {
            localObject = eBz();
            bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
            bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
            if ((!bool1) && (!bool2))
            {
              ae(false, paramBoolean);
              AppMethodBeat.o(110475);
              return;
              i += 1;
              break;
            }
          }
          ae(true, paramBoolean);
          AppMethodBeat.o(110475);
          return;
        }
        enableOptionMenu(0, false);
        ae(false, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      localObject = eBz();
      boolean bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
      boolean bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
      if ((i != 0) && ((bool1) || (bool2)))
      {
        enableOptionMenu(0, true);
        ae(true, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      enableOptionMenu(0, false);
      ae(false, paramBoolean);
      label317:
      AppMethodBeat.o(110475);
      return;
    }
  }
  
  private void sz(boolean paramBoolean)
  {
    AppMethodBeat.i(246574);
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    View localView = getLayoutInflater().inflate(b.f.DoD, null);
    ((TextView)localView.findViewById(b.e.Doj)).setText(this.Dqk.DpG.size() + 1);
    MMEditText localMMEditText = (MMEditText)localView.findViewById(b.e.Doi);
    CharSequence localCharSequence = bP(z.bcZ(), false);
    if (!Util.isNullOrNil(localCharSequence))
    {
      localMMEditText.setText(localCharSequence + " ");
      localb.content = String.valueOf(localCharSequence);
    }
    localb.username = z.bcZ();
    localb.bOX = this.Dqk.bOX;
    localb.DpK = (this.Dqk.DpG.size() + 1);
    localMMEditText.setTag(b.e.Dop, Integer.valueOf(3));
    localMMEditText.setTag(b.e.Don, localb);
    localMMEditText.requestFocus();
    localMMEditText.setFocusable(true);
    localMMEditText.setFocusableInTouchMode(true);
    localMMEditText.addTextChangedListener(this.uY);
    localMMEditText.setOnTouchListener(this.Dqu);
    b(localMMEditText);
    localMMEditText.setMaxLines(10);
    this.Dqk.DpG.put(Integer.valueOf(this.Dqk.DpG.size() + 1), localb);
    this.DpZ.addView(localView);
    this.Dqq.add(localView);
    localView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110434);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110434);
      }
    });
    sA(paramBoolean);
    AppMethodBeat.o(246574);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(110477);
    paramBoolean = this.BSf;
    if (paramInt > 0) {}
    for (this.BSf = true; (!paramBoolean) && (this.BSf); this.BSf = false)
    {
      localObject = this.Dqq.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.Dqi == 0) {
      this.Dqi = paramInt;
    }
    if (this.Dqn)
    {
      this.DpW.setMaxLines(c(this.DpW));
      this.Dqb.setMaxLines(c(this.Dqb));
    }
    if (this.Dqg != null)
    {
      if (!this.BSf) {
        this.Dqg.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(110436);
            ((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).setCursorVisible(false);
            AppMethodBeat.o(110436);
          }
        });
      }
    }
    else
    {
      if (!this.BSf) {
        break label293;
      }
      if (this.Dqc.getTranslationY() != 0.0F) {
        this.Dqc.setTranslationY(0.0F);
      }
    }
    label293:
    for (Object localObject = ObjectAnimator.ofFloat(this.Dqc, "translationY", new float[] { this.Dqc.getTranslationY(), this.Dqc.getTranslationY() - this.Dqi });; localObject = ObjectAnimator.ofFloat(this.Dqc, "translationY", new float[] { this.Dqc.getTranslationY(), this.Dqc.getTranslationY() + this.Dqi }))
    {
      ((ObjectAnimator)localObject).setDuration(175L);
      ((ObjectAnimator)localObject).setInterpolator(new androidx.f.a.a.b());
      ((ObjectAnimator)localObject).addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(110440);
          if (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this))
          {
            GroupSolitatireEditUI.s(GroupSolitatireEditUI.this).setVisibility(4);
            AppMethodBeat.o(110440);
            return;
          }
          GroupSolitatireEditUI.t(GroupSolitatireEditUI.this);
          if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).DpG.size() < com.tencent.mm.plugin.groupsolitaire.b.b.eBl()) {
            GroupSolitatireEditUI.s(GroupSolitatireEditUI.this).setVisibility(0);
          }
          GroupSolitatireEditUI.r(GroupSolitatireEditUI.this).setVisibility(8);
          AppMethodBeat.o(110440);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(110439);
          if (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)) {
            GroupSolitatireEditUI.r(GroupSolitatireEditUI.this).setVisibility(0);
          }
          AppMethodBeat.o(110439);
        }
      });
      ((ObjectAnimator)localObject).start();
      eBB();
      if (this.Dqg != null) {
        break label336;
      }
      AppMethodBeat.o(110477);
      return;
      this.Dqg.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110437);
          ((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).setCursorVisible(true);
          AppMethodBeat.o(110437);
        }
      }, 100L);
      break;
    }
    label336:
    this.Dqg.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110441);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
        AppMethodBeat.o(110441);
      }
    }, 50L);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(this.BSf), Integer.valueOf(paramInt), Integer.valueOf(this.Dqi) });
    AppMethodBeat.o(110477);
  }
  
  public final void Ui(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(110476);
    if ((this.Dqg == null) || (!(this.Dqg instanceof MMEditText)))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.Dqk, paramInt, 0);
      AppMethodBeat.o(110476);
      return;
    }
    switch (((Integer)((MMEditText)this.Dqg).getTag(b.e.Dop)).intValue())
    {
    }
    for (;;)
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.Dqk, paramInt, i);
      AppMethodBeat.o(110476);
      return;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 2;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(110485);
    GestureDetector localGestureDetector = this.aHB;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(110485);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(110469);
    super.finish();
    try
    {
      hideVKB();
      AppMethodBeat.o(110469);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "finish() hideVKB() %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(110469);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.DoE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110463);
    super.initView();
    setMMTitle(getString(b.g.DoY));
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.b.BW_93));
    setBackGroundColorResource(b.b.white);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110448);
        boolean bool = GroupSolitatireEditUI.h(GroupSolitatireEditUI.this);
        AppMethodBeat.o(110448);
        return bool;
      }
    });
    this.jij = new i(getContext());
    this.jij.XSx = this;
    this.mPe = ((ScrollView)findViewById(b.e.root_view));
    this.DpU = ((RelativeLayout)findViewById(b.e.root_container));
    this.DpV = ((CdnImageView)findViewById(b.e.Dok));
    this.mMA = ((TextView)findViewById(b.e.Dol));
    this.DpW = ((MMEditText)findViewById(b.e.Doq));
    this.DpX = findViewById(b.e.Dov);
    this.DpY = findViewById(b.e.Dow);
    this.DpZ = ((LinearLayout)findViewById(b.e.Dom));
    this.Dqa = ((ImageButton)findViewById(b.e.Doo));
    this.Dqb = ((MMEditText)findViewById(b.e.Doy));
    this.Dqc = ((LinearLayout)findViewById(b.e.Dor));
    this.Dqd = ((RelativeLayout)findViewById(b.e.Dos));
    this.Dqe = ((RelativeLayout)findViewById(b.e.Dot));
    this.Dqf = ((RelativeLayout)findViewById(b.e.Dou));
    this.mPf = findViewById(b.e.Dox);
    this.Dqd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110450);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.j(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.this.Ui(2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110450);
      }
    });
    this.Dqe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(110453);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new a(GroupSolitatireEditUI.this);
        paramAnonymousView.DpP = new a.a()
        {
          public final void aLd(String paramAnonymous2String)
          {
            AppMethodBeat.i(110451);
            paramAnonymousView.hide();
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymous2String);
            GroupSolitatireEditUI.this.Ui(5);
            AppMethodBeat.o(110451);
          }
          
          public final void onCancel()
          {
            AppMethodBeat.i(110452);
            paramAnonymousView.hide();
            AppMethodBeat.o(110452);
          }
        };
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymousView);
        paramAnonymousView.show();
        GroupSolitatireEditUI.this.Ui(4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110453);
      }
    });
    this.Dqf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110455);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new b(GroupSolitatireEditUI.this);
        int i;
        int j;
        label135:
        int k;
        if (paramAnonymousView.DpR != null)
        {
          i = paramAnonymousView.DpR.getYear();
          if (paramAnonymousView.DpR == null) {
            break label311;
          }
          j = paramAnonymousView.DpR.getMonth();
          if (paramAnonymousView.DpR == null) {
            break label316;
          }
          k = paramAnonymousView.DpR.getDayOfMonth();
          label151:
          paramAnonymousView.DpS = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(110454);
              if (paramAnonymous2Boolean)
              {
                Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitaire time :%s", new Object[] { String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }) });
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, String.format(Locale.US, "%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }));
                GroupSolitatireEditUI.this.Ui(1);
              }
              AppMethodBeat.o(110454);
            }
          };
          if ((i >= 0) && (j >= 0) && (k >= 0)) {
            break label322;
          }
        }
        for (;;)
        {
          localObject = Calendar.getInstance(Locale.US);
          ((Calendar)localObject).set(2009, 0, 1);
          if (paramAnonymousView.DpR != null) {
            paramAnonymousView.DpR.setMinDate(((Calendar)localObject).getTimeInMillis());
          }
          localObject = Calendar.getInstance(Locale.US);
          ((Calendar)localObject).set(2029, 11, 31);
          if (paramAnonymousView.DpR != null) {
            paramAnonymousView.DpR.setMaxDate(((Calendar)localObject).getTimeInMillis());
          }
          if (paramAnonymousView.DpN != null)
          {
            if (paramAnonymousView.DpR != null) {
              paramAnonymousView.DpR.cpH();
            }
            paramAnonymousView.DpN.show();
          }
          GroupSolitatireEditUI.this.Ui(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110455);
          return;
          i = 0;
          break;
          label311:
          j = 0;
          break label135;
          label316:
          k = 0;
          break label151;
          label322:
          if (paramAnonymousView.DpR != null) {
            paramAnonymousView.DpR.a(i, j, k, null);
          }
        }
      }
    });
    addTextOptionMenu(0, getString(b.g.DoU), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110458);
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "send group solitaire(sending:%s)", new Object[] { Boolean.valueOf(GroupSolitatireEditUI.k(GroupSolitatireEditUI.this)) });
        if (GroupSolitatireEditUI.k(GroupSolitatireEditUI.this))
        {
          AppMethodBeat.o(110458);
          return true;
        }
        com.tencent.mm.plugin.groupsolitaire.b.b.a(GroupSolitatireEditUI.l(GroupSolitatireEditUI.this), z.bcZ(), GroupSolitatireEditUI.c(GroupSolitatireEditUI.this));
        if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).DpH) {
          com.tencent.mm.ui.base.h.c(GroupSolitatireEditUI.this.getContext(), GroupSolitatireEditUI.this.getString(b.g.DoT), "", GroupSolitatireEditUI.this.getString(b.g.DoS), GroupSolitatireEditUI.this.getString(b.g.DoR), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110456);
              Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog ok");
              GroupSolitatireEditUI.m(GroupSolitatireEditUI.this);
              AppMethodBeat.o(110456);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110457);
              Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog cancel");
              AppMethodBeat.o(110457);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(110458);
          return true;
          GroupSolitatireEditUI.m(GroupSolitatireEditUI.this);
        }
      }
    }, null, w.b.Wao);
    Object localObject1;
    if (this.Dqn)
    {
      enableOptionMenu(0, true);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110459);
          Bitmap localBitmap = com.tencent.mm.am.d.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).field_creator, false, -1, null);
          if (localBitmap == null)
          {
            GroupSolitatireEditUI.n(GroupSolitatireEditUI.this).setImageResource(b.d.default_avatar);
            AppMethodBeat.o(110459);
            return;
          }
          GroupSolitatireEditUI.n(GroupSolitatireEditUI.this).setImageBitmap(localBitmap);
          AppMethodBeat.o(110459);
        }
      };
      if (!MMHandlerThread.isMainThread()) {
        break label465;
      }
      ((Runnable)localObject1).run();
    }
    for (;;)
    {
      if (this.Dqk.DpG.size() <= 0) {
        break label1483;
      }
      localObject1 = new HashSet();
      i = 1;
      while (i <= this.Dqk.DpG.size())
      {
        ((Set)localObject1).add(((com.tencent.mm.plugin.groupsolitaire.c.b)this.Dqk.DpG.get(Integer.valueOf(i))).username);
        i += 1;
      }
      enableOptionMenu(0, false);
      break;
      label465:
      MMHandlerThread.postToMainThread(new GroupSolitatireEditUI.2(this, (Runnable)localObject1));
    }
    label790:
    label929:
    label1072:
    label1097:
    label1483:
    for (int i = ((Set)localObject1).size();; i = 0)
    {
      this.mMA.setText(getString(b.g.Dpa, new Object[] { bP(this.Dqk.field_creator, true), String.valueOf(i) }));
      Object localObject2;
      if ((!Util.isNullOrNil(this.Dqk.header)) && (this.Dqk.DpE == 1))
      {
        localObject2 = this.Dqk.header;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aKZ((String)localObject2) > com.tencent.mm.plugin.groupsolitaire.b.b.eBn() * 2)
          {
            localObject1 = ((String)localObject2).substring(0, com.tencent.mm.plugin.groupsolitaire.b.b.eL((String)localObject2, com.tencent.mm.plugin.groupsolitaire.b.b.eBn() * 2));
            this.Dqk.header = ((String)localObject1);
          }
        }
        localObject2 = this.DpW.getContext();
        this.DpW.getTextSize();
        localObject1 = l.e((Context)localObject2, (CharSequence)localObject1, 1);
        this.DpW.setText((CharSequence)localObject1);
        if ((this.Dqn) && (!Util.isNullOrNil(this.Dqk.header)) && (this.Dqk.DpE == 0))
        {
          this.Dqk.DpE = 1;
          this.Dqk.header = "";
          if ((this.Dqk.DpG.size() > 0) && (((com.tencent.mm.plugin.groupsolitaire.c.b)this.Dqk.DpG.get(Integer.valueOf(1))).DpJ == 1)) {
            ((com.tencent.mm.plugin.groupsolitaire.c.b)this.Dqk.DpG.get(Integer.valueOf(1))).DpJ = 0;
          }
        }
        if (Util.isNullOrNil(this.Dqk.CBX)) {
          break label1347;
        }
        localObject1 = this.Dqb.getContext();
        localObject2 = this.Dqk.CBX;
        this.Dqb.getTextSize();
        localObject1 = l.e((Context)localObject1, (CharSequence)localObject2, 1);
        this.Dqb.setText((CharSequence)localObject1);
        if (!this.Dqn) {
          break label1379;
        }
        this.DpW.setFocusable(true);
        this.DpW.setFocusableInTouchMode(true);
        this.DpW.requestFocus();
        this.DpW.setOnTouchListener(this.Dqu);
        if (Util.isNullOrNil(this.Dqk.header)) {
          this.DpW.setHeight(com.tencent.mm.ci.a.fromDPToPix(getContext(), 160));
        }
        this.DpW.addTextChangedListener(this.uY);
        this.DpW.setMaxLines(10);
        this.Dqb.setFocusable(true);
        this.Dqb.setFocusableInTouchMode(true);
        this.Dqb.addTextChangedListener(this.uY);
        this.Dqb.setOnTouchListener(this.Dqu);
        this.Dqb.setMaxLines(10);
        this.DpW.setTag(b.e.Dop, Integer.valueOf(1));
        this.Dqb.setTag(b.e.Dop, Integer.valueOf(4));
        if ((!Util.isNullOrNil(this.Dqk.DpD)) || (this.Dqn))
        {
          localObject1 = getLayoutInflater().inflate(b.f.DoD, null);
          ((TextView)((View)localObject1).findViewById(b.e.Doj)).setText(getString(b.g.DoP));
          localObject2 = (MMEditText)((View)localObject1).findViewById(b.e.Doi);
          ((MMEditText)localObject2).setTag(b.e.Dop, Integer.valueOf(2));
          if (Util.isNullOrNil(this.Dqk.DpD)) {
            break label1414;
          }
          ((MMEditText)localObject2).setText(l.d(((MMEditText)localObject2).getContext(), this.Dqk.DpD, (int)((MMEditText)localObject2).getTextSize()));
          this.Dqh = false;
          if (!this.Dqn) {
            break label1429;
          }
          ((MMEditText)localObject2).setFocusable(true);
          ((MMEditText)localObject2).setFocusableInTouchMode(true);
          ((MMEditText)localObject2).addTextChangedListener(this.uY);
          ((MMEditText)localObject2).setOnTouchListener(this.Dqu);
          ((MMEditText)localObject2).setMaxLines(10);
          this.DpZ.addView((View)localObject1);
        }
        eBy();
        if (this.Dqk.DpG.size() < com.tencent.mm.plugin.groupsolitaire.b.b.eBl()) {
          this.Dqa.setOnClickListener(new GroupSolitatireEditUI.5(this));
        }
        if ((this.scene != 2) && ((!eBw()) || (this.Dqk.DpI <= 0)) && (this.scene != 5)) {
          break label1456;
        }
        sz(true);
        if ((this.Dqn) && (eBx())) {
          this.DpW.requestFocus();
        }
      }
      for (;;)
      {
        if (this.Dqn) {
          this.Dql = this.Dqk.eBt();
        }
        eBB();
        sA(true);
        b(this.Dqb);
        b(this.DpW);
        this.aHB = new GestureDetector(this, new GroupSolitatireEditUI.19(this));
        this.Dqr = new Rect();
        this.Dqs = new Rect();
        AppMethodBeat.o(110463);
        return;
        if (!this.Dqn)
        {
          this.DpW.setVisibility(8);
          this.DpX.setVisibility(8);
          break;
        }
        this.DpW.setHint(b.g.DoZ);
        break;
        if (!this.Dqn)
        {
          this.Dqb.setVisibility(8);
          break label790;
        }
        this.Dqb.setHint(b.g.DoV);
        break label790;
        label1379:
        this.DpW.setKeyListener(null);
        this.DpW.setTextIsSelectable(true);
        this.Dqb.setKeyListener(null);
        this.Dqb.setTextIsSelectable(true);
        break label929;
        ((MMEditText)localObject2).setHint(b.g.DoO);
        this.Dqh = true;
        break label1072;
        ((MMEditText)localObject2).setTextColor(getResources().getColor(b.b.BW_50));
        ((MMEditText)localObject2).setKeyListener(null);
        ((MMEditText)localObject2).setTextIsSelectable(true);
        break label1097;
        if (this.scene == 1) {
          this.mPe.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110449);
              GroupSolitatireEditUI.i(GroupSolitatireEditUI.this).fullScroll(33);
              AppMethodBeat.o(110449);
            }
          });
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(110478);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((MMEditText)this.Dqg).requestFocus();
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(110478);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110478);
      return;
      String str1 = Util.nullAs(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      String str2 = paramIntent.getStringExtra("kPoiName");
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_LOC address: %s, poiName：%s", new Object[] { str1, str2 });
      paramIntent = str1;
      if (str1.contains(getString(b.g.DoH))) {
        paramIntent = str1.substring(str1.indexOf(getString(b.g.DoH)) + 1);
      }
      aLe(str2 + "(" + paramIntent + ")");
      Ui(3);
      AppMethodBeat.o(110478);
      return;
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_CONTACT");
      if (this.Dqt != null) {
        this.Dqt.show();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110461);
    super.onCreate(paramBundle);
    this.Dqn = getIntent().getBooleanExtra("key_group_solitatire_create", false);
    String str1 = getIntent().getStringExtra("key_group_solitatire_key");
    this.Dqm = getIntent().getStringExtra("key_group_solitatire_chatroom_username");
    this.scene = getIntent().getIntExtra("key_group_solitatire_scene", 3);
    int i;
    if ((this.scene == 3) || (eBx()))
    {
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager();
      String str2 = this.Dqm;
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getTempGroupSolitatireFromCache() username:%s key:%s", new Object[] { str2, str1 });
      paramBundle = (com.tencent.mm.plugin.groupsolitaire.c.a)paramBundle.Dpi.get(str2 + str1);
      if (paramBundle != null) {
        break label213;
      }
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s temp == null", new Object[] { str1 });
      finish();
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label320;
      }
      AppMethodBeat.o(110461);
      return;
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ik(this.Dqm, str1);
      break;
      label213:
      this.Dqk = paramBundle.eBt();
      if (this.Dqk == null)
      {
        Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s mGroupSolitatire == null", new Object[] { str1 });
        finish();
        i = 0;
      }
      else
      {
        this.Dql = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ik(this.Dqm, this.Dqk.field_key);
        this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.Dqm);
        setResult(0);
        i = 1;
      }
    }
    label320:
    initView();
    setNavigationbarColor(getResources().getColor(b.b.white));
    AppMethodBeat.o(110461);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110470);
    super.onDestroy();
    AppMethodBeat.o(110470);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110462);
    if (paramInt == 4)
    {
      if (!this.BSf) {
        asJ();
      }
      AppMethodBeat.o(110462);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(110462);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110468);
    super.onPause();
    if (this.jij != null) {
      this.jij.close();
    }
    AppMethodBeat.o(110468);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110479);
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(110479);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult OK");
      eBA();
      AppMethodBeat.o(110479);
      return;
    }
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult failed");
    com.tencent.mm.ui.base.h.a(getContext(), getString(b.g.permission_location_request_again_msg), getString(b.g.permission_tips_title), getString(b.g.jump_to_settings), getString(b.g.permission_dialog_cancel), false, new GroupSolitatireEditUI.15(this), null);
    AppMethodBeat.o(110479);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110467);
    super.onResume();
    this.mPe.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110432);
        if (GroupSolitatireEditUI.q(GroupSolitatireEditUI.this) != null) {
          GroupSolitatireEditUI.q(GroupSolitatireEditUI.this).start();
        }
        AppMethodBeat.o(110432);
      }
    });
    if ((this.scene == 2) || (eBw()) || (this.scene == 5)) {
      this.DpZ.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110433);
          GroupSolitatireEditUI.this.showVKB();
          AppMethodBeat.o(110433);
        }
      }, 200L);
    }
    AppMethodBeat.o(110467);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI
 * JD-Core Version:    0.7.0.1
 */