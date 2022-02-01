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
import android.view.GestureDetector.OnGestureListener;
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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
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
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.t.b;
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
  implements com.tencent.mm.ui.tools.g
{
  private GestureDetector aYg;
  private TextWatcher aws;
  private boolean dAE;
  private ah gtd;
  private com.tencent.mm.ui.tools.h gyh;
  private TextView jVn;
  private ScrollView lTw;
  private RelativeLayout onl;
  private int scene;
  private boolean thl;
  private boolean xfU;
  private CdnImageView yfS;
  private MMEditText yfT;
  private View yfU;
  private View yfV;
  private LinearLayout yfW;
  private ImageButton yfX;
  private MMEditText yfY;
  private LinearLayout yfZ;
  private RelativeLayout yga;
  private RelativeLayout ygb;
  private RelativeLayout ygc;
  private View ygd;
  private View yge;
  private boolean ygf;
  private int ygg;
  private int ygh;
  private com.tencent.mm.plugin.groupsolitaire.c.a ygi;
  private com.tencent.mm.plugin.groupsolitaire.c.a ygj;
  private String ygk;
  private boolean ygl;
  private boolean ygm;
  private boolean ygn;
  private ArrayList<View> ygo;
  private Rect ygp;
  private Rect ygq;
  private a ygr;
  private View.OnTouchListener ygs;
  
  public GroupSolitatireEditUI()
  {
    AppMethodBeat.i(110460);
    this.ygf = false;
    this.ygi = null;
    this.ygj = null;
    this.ygk = "";
    this.ygl = false;
    this.xfU = false;
    this.thl = false;
    this.ygm = false;
    this.ygn = false;
    this.ygo = new ArrayList();
    this.dAE = false;
    this.aws = new TextWatcher()
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
          String str = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW((String)localObject1);
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
            if (j > com.tencent.mm.plugin.groupsolitaire.b.b.dXP() * 2)
            {
              i = com.tencent.mm.plugin.groupsolitaire.b.b.em((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.dXP() * 2);
              paramAnonymousEditable.delete(i, ((String)localObject1).length());
              localObject2 = ((String)localObject1).substring(0, i);
            }
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).header = ((String)localObject2);
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).yfC = 1;
            continue;
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).yfB = ((String)localObject1);
            continue;
            com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131302198);
            if (localb != null)
            {
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.dXO() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.em((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.dXO() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              localb.content = ((String)localObject2);
              continue;
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.dXQ() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.em((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.dXQ() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).xxN = ((String)localObject2);
            }
          }
        }
        i = ((Integer)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131302200)).intValue();
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() str:%s type:%s", new Object[] { localObject1, Integer.valueOf(i) });
        j = com.tencent.mm.plugin.groupsolitaire.b.b.aBl((String)localObject1);
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
    this.ygs = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110438);
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (GroupSolitatireEditUI.f(GroupSolitatireEditUI.this))) {
          ((MMEditText)paramAnonymousView).setCursorVisible(true);
        }
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (((Integer)((MMEditText)paramAnonymousView).getTag(2131302200)).intValue() == 3) && (GroupSolitatireEditUI.g(GroupSolitatireEditUI.this))) {
          ((MMEditText)paramAnonymousView).setCursorVisible(true);
        }
        if (GroupSolitatireEditUI.c((MMEditText)paramAnonymousView))
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
  
  private String DH(String paramString)
  {
    AppMethodBeat.i(110473);
    if (this.gtd == null)
    {
      AppMethodBeat.o(110473);
      return null;
    }
    paramString = this.gtd.getDisplayName(paramString);
    AppMethodBeat.o(110473);
    return paramString;
  }
  
  private void V(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.thl = paramBoolean1;
    }
  }
  
  private void a(final MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110483);
    paramMMEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194441);
        if ((paramAnonymousBoolean) && (GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) != null) && (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)))
        {
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194439);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
              AppMethodBeat.o(194439);
            }
          }, 200L);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194440);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(194440);
            }
          }, 200L);
          AppMethodBeat.o(194441);
          return;
        }
        paramMMEditText.setSelection(0);
        AppMethodBeat.o(194441);
      }
    });
    AppMethodBeat.o(110483);
  }
  
  private void aBq(String paramString)
  {
    AppMethodBeat.i(110481);
    ((MMEditText)this.yge).requestFocus();
    this.yfW.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110443);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110443);
      }
    }, 200L);
    ((MMEditText)this.yge).getText().insert(this.ygh, paramString + "; ");
    AppMethodBeat.o(110481);
  }
  
  private boolean amI()
  {
    AppMethodBeat.i(110464);
    if (this.thl) {
      com.tencent.mm.ui.base.h.a(this, getString(2131761472), "", getString(2131761471), getString(2131761470), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110429);
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot ok");
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this), GroupSolitatireEditUI.o(GroupSolitatireEditUI.this), 2, GroupSolitatireEditUI.f(GroupSolitatireEditUI.this));
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
      }, 2131100994);
    }
    for (;;)
    {
      AppMethodBeat.o(110464);
      return true;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      d.a(this.ygi, dXX(), 1, this.ygl);
      finish();
    }
  }
  
  private int b(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110484);
    if (this.ygg == 0)
    {
      AppMethodBeat.o(110484);
      return 10;
    }
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
    float f = paramMMEditText.getLineHeight();
    i = (int)((i - (this.ygg + this.yfZ.getHeight() + at.fromDPToPix(this, 145))) / f);
    AppMethodBeat.o(110484);
    return i;
  }
  
  private CharSequence bK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110472);
    com.tencent.mm.kernel.g.aAi();
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((paramBoolean) && (!Util.isNullOrNil(localas.field_conRemark))) {}
    for (String str = localas.field_conRemark;; str = DH(localas.field_username))
    {
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = localas.field_conRemark;
      }
      str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = localas.arI();
      }
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = localas.field_username;
      }
      paramString = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), paramString);
      AppMethodBeat.o(110472);
      return paramString;
    }
  }
  
  private int dXX()
  {
    AppMethodBeat.i(110465);
    if (dXY())
    {
      AppMethodBeat.o(110465);
      return 3;
    }
    int i = this.scene;
    AppMethodBeat.o(110465);
    return i;
  }
  
  private boolean dXY()
  {
    return (this.scene == 3) || (this.scene == 4);
  }
  
  private boolean dXZ()
  {
    return (this.scene == 4) || (this.scene == 5);
  }
  
  private void dYa()
  {
    AppMethodBeat.i(110466);
    int j = 1;
    int i = 1;
    MMEditText localMMEditText;
    if (j <= this.ygi.yfE.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.ygi.yfE.get(Integer.valueOf(j));
      if (localb == null) {
        break label287;
      }
      View localView = getLayoutInflater().inflate(2131494999, null);
      ((TextView)localView.findViewById(2131302194)).setText(String.valueOf(i));
      localMMEditText = (MMEditText)localView.findViewById(2131302193);
      localMMEditText.setTag(2131302200, Integer.valueOf(3));
      localMMEditText.setTag(2131302198, localb);
      localMMEditText.setText(com.tencent.mm.pluginsdk.ui.span.l.e(localMMEditText.getContext(), localb.content, (int)localMMEditText.getTextSize()));
      if (Util.isEqual(localb.username, z.aTY()))
      {
        this.ygn = true;
        localMMEditText.requestFocus();
        localMMEditText.setFocusable(true);
        localMMEditText.setFocusableInTouchMode(true);
        localMMEditText.addTextChangedListener(this.aws);
        if (this.scene == 1) {
          localMMEditText.setCursorVisible(false);
        }
        label193:
        localMMEditText.setOnTouchListener(this.ygs);
        localMMEditText.setMaxLines(10);
        this.yfW.addView(localView);
        this.ygo.add(localView);
        a(localMMEditText);
        i += 1;
      }
    }
    label287:
    for (;;)
    {
      j += 1;
      break;
      this.ygn = false;
      localMMEditText.setTextColor(getResources().getColor(2131099683));
      localMMEditText.setKeyListener(null);
      localMMEditText.setTextIsSelectable(true);
      break label193;
      AppMethodBeat.o(110466);
      return;
    }
  }
  
  private Pair<Boolean, Boolean> dYb()
  {
    boolean bool4 = false;
    AppMethodBeat.i(194446);
    Object localObject1 = new HashSet();
    int i = 1;
    while (i <= this.ygj.yfE.size())
    {
      localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)this.ygj.yfE.get(Integer.valueOf(i));
      if (Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).username, z.aTY())) {
        ((Set)localObject1).add(localObject2);
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    HashSet localHashSet = new HashSet();
    i = 1;
    while (i <= this.ygi.yfE.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.ygi.yfE.get(Integer.valueOf(i));
      if ((Util.isEqual(localb.username, z.aTY())) && (!Util.isNullOrNil(localb.content.trim())))
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
      AppMethodBeat.o(194446);
      return localObject1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void dYc()
  {
    AppMethodBeat.i(110480);
    if (com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_FINE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oho, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getResources().getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
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
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
    localIntent.putExtra("map_view_type", 3);
    com.tencent.mm.br.c.b(this, "location", ".ui.RedirectUI", localIntent, 4097);
    AppMethodBeat.o(110480);
  }
  
  private void dYd()
  {
    AppMethodBeat.i(110482);
    if (this.onl.findFocus() == null)
    {
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "mRootContainer.findFocus() is null");
      AppMethodBeat.o(110482);
      return;
    }
    this.yge = this.onl.findFocus();
    this.ygh = ((MMEditText)this.yge).getSelectionStart();
    AppMethodBeat.o(110482);
  }
  
  private void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(194445);
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    View localView = getLayoutInflater().inflate(2131494999, null);
    ((TextView)localView.findViewById(2131302194)).setText(this.ygi.yfE.size() + 1);
    MMEditText localMMEditText = (MMEditText)localView.findViewById(2131302193);
    CharSequence localCharSequence = bK(z.aTY(), false);
    if (!Util.isNullOrNil(localCharSequence))
    {
      localMMEditText.setText(localCharSequence + " ");
      localb.content = String.valueOf(localCharSequence);
    }
    localb.username = z.aTY();
    localb.separator = this.ygi.separator;
    localb.yfI = (this.ygi.yfE.size() + 1);
    localMMEditText.setTag(2131302200, Integer.valueOf(3));
    localMMEditText.setTag(2131302198, localb);
    localMMEditText.requestFocus();
    localMMEditText.setFocusable(true);
    localMMEditText.setFocusableInTouchMode(true);
    localMMEditText.addTextChangedListener(this.aws);
    localMMEditText.setOnTouchListener(this.ygs);
    a(localMMEditText);
    localMMEditText.setMaxLines(10);
    this.ygi.yfE.put(Integer.valueOf(this.ygi.yfE.size() + 1), localb);
    this.yfW.addView(localView);
    this.ygo.add(localView);
    localView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110434);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110434);
      }
    });
    qa(paramBoolean);
    AppMethodBeat.o(194445);
  }
  
  private void qa(boolean paramBoolean)
  {
    AppMethodBeat.i(110475);
    int i = 1;
    Object localObject;
    if (i <= this.ygi.yfE.size())
    {
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)this.ygi.yfE.get(Integer.valueOf(i));
      if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content.trim()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (this.ygl)
      {
        if (i != 0)
        {
          enableOptionMenu(0, true);
          if (paramBoolean) {
            break label317;
          }
          if ((this.ygj != null) && (Util.isEqual(this.ygi.header, this.ygj.header)) && (Util.isEqual(this.ygi.yfB, this.ygj.yfB)) && (Util.isEqual(this.ygi.xxN, this.ygj.xxN)))
          {
            localObject = dYb();
            bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
            bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
            if ((!bool1) && (!bool2))
            {
              V(false, paramBoolean);
              AppMethodBeat.o(110475);
              return;
              i += 1;
              break;
            }
          }
          V(true, paramBoolean);
          AppMethodBeat.o(110475);
          return;
        }
        enableOptionMenu(0, false);
        V(false, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      localObject = dYb();
      boolean bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
      boolean bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
      if ((i != 0) && ((bool1) || (bool2)))
      {
        enableOptionMenu(0, true);
        V(true, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      enableOptionMenu(0, false);
      V(false, paramBoolean);
      label317:
      AppMethodBeat.o(110475);
      return;
    }
  }
  
  public final void OI(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(110476);
    if ((this.yge == null) || (!(this.yge instanceof MMEditText)))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      d.a(this.ygi, paramInt, 0);
      AppMethodBeat.o(110476);
      return;
    }
    switch (((Integer)((MMEditText)this.yge).getTag(2131302200)).intValue())
    {
    }
    for (;;)
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      d.a(this.ygi, paramInt, i);
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
    GestureDetector localGestureDetector = this.aYg;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
    return 2131495000;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110463);
    super.initView();
    setMMTitle(getString(2131761496));
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131099689));
    setBackGroundColorResource(2131101424);
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
    this.gyh = new com.tencent.mm.ui.tools.h(getContext());
    this.gyh.Quk = this;
    this.lTw = ((ScrollView)findViewById(2131307173));
    this.onl = ((RelativeLayout)findViewById(2131307160));
    this.yfS = ((CdnImageView)findViewById(2131302195));
    this.jVn = ((TextView)findViewById(2131302196));
    this.yfT = ((MMEditText)findViewById(2131302201));
    this.yfU = findViewById(2131302207);
    this.yfV = findViewById(2131302208);
    this.yfW = ((LinearLayout)findViewById(2131302197));
    this.yfX = ((ImageButton)findViewById(2131302199));
    this.yfY = ((MMEditText)findViewById(2131302210));
    this.yfZ = ((LinearLayout)findViewById(2131302202));
    this.yga = ((RelativeLayout)findViewById(2131302203));
    this.ygb = ((RelativeLayout)findViewById(2131302204));
    this.ygc = ((RelativeLayout)findViewById(2131302205));
    this.ygd = findViewById(2131302209);
    this.yga.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110450);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.j(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.this.OI(2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110450);
      }
    });
    this.ygb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(110453);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new a(GroupSolitatireEditUI.this);
        paramAnonymousView.yfN = new a.a()
        {
          public final void aBp(String paramAnonymous2String)
          {
            AppMethodBeat.i(110451);
            paramAnonymousView.hide();
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymous2String);
            GroupSolitatireEditUI.this.OI(5);
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
        GroupSolitatireEditUI.this.OI(4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110453);
      }
    });
    this.ygc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110455);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new b(GroupSolitatireEditUI.this);
        int i;
        int j;
        label135:
        int k;
        if (paramAnonymousView.yfP != null)
        {
          i = paramAnonymousView.yfP.getYear();
          if (paramAnonymousView.yfP == null) {
            break label311;
          }
          j = paramAnonymousView.yfP.getMonth();
          if (paramAnonymousView.yfP == null) {
            break label316;
          }
          k = paramAnonymousView.yfP.getDayOfMonth();
          label151:
          paramAnonymousView.yfQ = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(110454);
              if (paramAnonymous2Boolean)
              {
                Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitaire time :%s", new Object[] { String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }) });
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, String.format(Locale.US, "%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }));
                GroupSolitatireEditUI.this.OI(1);
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
          if (paramAnonymousView.yfP != null) {
            paramAnonymousView.yfP.setMinDate(((Calendar)localObject).getTimeInMillis());
          }
          localObject = Calendar.getInstance(Locale.US);
          ((Calendar)localObject).set(2029, 11, 31);
          if (paramAnonymousView.yfP != null) {
            paramAnonymousView.yfP.setMaxDate(((Calendar)localObject).getTimeInMillis());
          }
          if (paramAnonymousView.yfL != null)
          {
            if (paramAnonymousView.yfP != null) {
              paramAnonymousView.yfP.ccq();
            }
            paramAnonymousView.yfL.show();
          }
          GroupSolitatireEditUI.this.OI(0);
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
          if (paramAnonymousView.yfP != null) {
            paramAnonymousView.yfP.a(i, j, k, null);
          }
        }
      }
    });
    addTextOptionMenu(0, getString(2131761488), new MenuItem.OnMenuItemClickListener()
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
        com.tencent.mm.plugin.groupsolitaire.b.b.a(GroupSolitatireEditUI.l(GroupSolitatireEditUI.this), z.aTY(), GroupSolitatireEditUI.c(GroupSolitatireEditUI.this));
        if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).yfF) {
          com.tencent.mm.ui.base.h.c(GroupSolitatireEditUI.this.getContext(), GroupSolitatireEditUI.this.getString(2131761486), "", GroupSolitatireEditUI.this.getString(2131761485), GroupSolitatireEditUI.this.getString(2131761484), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    }, null, t.b.OGU);
    Object localObject1;
    if (this.ygl)
    {
      enableOptionMenu(0, true);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110459);
          Bitmap localBitmap = com.tencent.mm.aj.c.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).field_creator, false, -1, null);
          if (localBitmap == null)
          {
            GroupSolitatireEditUI.n(GroupSolitatireEditUI.this).setImageResource(2131231957);
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
      if (this.ygi.yfE.size() <= 0) {
        break label1483;
      }
      localObject1 = new HashSet();
      i = 1;
      while (i <= this.ygi.yfE.size())
      {
        ((Set)localObject1).add(((com.tencent.mm.plugin.groupsolitaire.c.b)this.ygi.yfE.get(Integer.valueOf(i))).username);
        i += 1;
      }
      enableOptionMenu(0, false);
      break;
      label465:
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110428);
          this.val$run.run();
          AppMethodBeat.o(110428);
        }
      });
    }
    label790:
    label929:
    label1072:
    label1097:
    label1483:
    for (int i = ((Set)localObject1).size();; i = 0)
    {
      this.jVn.setText(getString(2131761500, new Object[] { bK(this.ygi.field_creator, true), String.valueOf(i) }));
      Object localObject2;
      if ((!Util.isNullOrNil(this.ygi.header)) && (this.ygi.yfC == 1))
      {
        localObject2 = this.ygi.header;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aBl((String)localObject2) > com.tencent.mm.plugin.groupsolitaire.b.b.dXP() * 2)
          {
            localObject1 = ((String)localObject2).substring(0, com.tencent.mm.plugin.groupsolitaire.b.b.em((String)localObject2, com.tencent.mm.plugin.groupsolitaire.b.b.dXP() * 2));
            this.ygi.header = ((String)localObject1);
          }
        }
        localObject2 = this.yfT.getContext();
        this.yfT.getTextSize();
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.f((Context)localObject2, (CharSequence)localObject1, 1);
        this.yfT.setText((CharSequence)localObject1);
        if ((this.ygl) && (!Util.isNullOrNil(this.ygi.header)) && (this.ygi.yfC == 0))
        {
          this.ygi.yfC = 1;
          this.ygi.header = "";
          if ((this.ygi.yfE.size() > 0) && (((com.tencent.mm.plugin.groupsolitaire.c.b)this.ygi.yfE.get(Integer.valueOf(1))).yfH == 1)) {
            ((com.tencent.mm.plugin.groupsolitaire.c.b)this.ygi.yfE.get(Integer.valueOf(1))).yfH = 0;
          }
        }
        if (Util.isNullOrNil(this.ygi.xxN)) {
          break label1347;
        }
        localObject1 = this.yfY.getContext();
        localObject2 = this.ygi.xxN;
        this.yfY.getTextSize();
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.f((Context)localObject1, (CharSequence)localObject2, 1);
        this.yfY.setText((CharSequence)localObject1);
        if (!this.ygl) {
          break label1379;
        }
        this.yfT.setFocusable(true);
        this.yfT.setFocusableInTouchMode(true);
        this.yfT.requestFocus();
        this.yfT.setOnTouchListener(this.ygs);
        if (Util.isNullOrNil(this.ygi.header)) {
          this.yfT.setHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 160));
        }
        this.yfT.addTextChangedListener(this.aws);
        this.yfT.setMaxLines(10);
        this.yfY.setFocusable(true);
        this.yfY.setFocusableInTouchMode(true);
        this.yfY.addTextChangedListener(this.aws);
        this.yfY.setOnTouchListener(this.ygs);
        this.yfY.setMaxLines(10);
        this.yfT.setTag(2131302200, Integer.valueOf(1));
        this.yfY.setTag(2131302200, Integer.valueOf(4));
        if ((!Util.isNullOrNil(this.ygi.yfB)) || (this.ygl))
        {
          localObject1 = getLayoutInflater().inflate(2131494999, null);
          ((TextView)((View)localObject1).findViewById(2131302194)).setText(getString(2131761479));
          localObject2 = (MMEditText)((View)localObject1).findViewById(2131302193);
          ((MMEditText)localObject2).setTag(2131302200, Integer.valueOf(2));
          if (Util.isNullOrNil(this.ygi.yfB)) {
            break label1414;
          }
          ((MMEditText)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.e(((MMEditText)localObject2).getContext(), this.ygi.yfB, (int)((MMEditText)localObject2).getTextSize()));
          this.ygf = false;
          if (!this.ygl) {
            break label1429;
          }
          ((MMEditText)localObject2).setFocusable(true);
          ((MMEditText)localObject2).setFocusableInTouchMode(true);
          ((MMEditText)localObject2).addTextChangedListener(this.aws);
          ((MMEditText)localObject2).setOnTouchListener(this.ygs);
          ((MMEditText)localObject2).setMaxLines(10);
          this.yfW.addView((View)localObject1);
        }
        dYa();
        if (this.ygi.yfE.size() < com.tencent.mm.plugin.groupsolitaire.b.b.dXN()) {
          this.yfX.setOnClickListener(new GroupSolitatireEditUI.5(this));
        }
        if ((this.scene != 2) && ((!dXY()) || (this.ygi.yfG <= 0)) && (this.scene != 5)) {
          break label1456;
        }
        pZ(true);
        if ((this.ygl) && (dXZ())) {
          this.yfT.requestFocus();
        }
      }
      for (;;)
      {
        if (this.ygl) {
          this.ygj = this.ygi.dXV();
        }
        dYd();
        qa(true);
        a(this.yfY);
        a(this.yfT);
        this.aYg = new GestureDetector(this, new GestureDetector.OnGestureListener()
        {
          public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
          
          public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            return false;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(194444);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(194444);
          }
          
          public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            AppMethodBeat.i(194442);
            if (!GroupSolitatireEditUI.u(GroupSolitatireEditUI.this)) {
              GroupSolitatireEditUI.this.hideVKB();
            }
            AppMethodBeat.o(194442);
            return false;
          }
          
          public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(194443);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(194443);
            return false;
          }
        });
        this.ygp = new Rect();
        this.ygq = new Rect();
        AppMethodBeat.o(110463);
        return;
        if (!this.ygl)
        {
          this.yfT.setVisibility(8);
          this.yfU.setVisibility(8);
          break;
        }
        this.yfT.setHint(2131761498);
        break;
        if (!this.ygl)
        {
          this.yfY.setVisibility(8);
          break label790;
        }
        this.yfY.setHint(2131761489);
        break label790;
        label1379:
        this.yfT.setKeyListener(null);
        this.yfT.setTextIsSelectable(true);
        this.yfY.setKeyListener(null);
        this.yfY.setTextIsSelectable(true);
        break label929;
        ((MMEditText)localObject2).setHint(2131761478);
        this.ygf = true;
        break label1072;
        ((MMEditText)localObject2).setTextColor(getResources().getColor(2131099683));
        ((MMEditText)localObject2).setKeyListener(null);
        ((MMEditText)localObject2).setTextIsSelectable(true);
        break label1097;
        if (this.scene == 1) {
          this.lTw.post(new Runnable()
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
    ((MMEditText)this.yge).requestFocus();
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
      if (str1.contains(getString(2131761466))) {
        paramIntent = str1.substring(str1.indexOf(getString(2131761466)) + 1);
      }
      aBq(str2 + "(" + paramIntent + ")");
      OI(3);
      AppMethodBeat.o(110478);
      return;
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_CONTACT");
      if (this.ygr != null) {
        this.ygr.show();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110461);
    super.onCreate(paramBundle);
    this.ygl = getIntent().getBooleanExtra("key_group_solitatire_create", false);
    String str1 = getIntent().getStringExtra("key_group_solitatire_key");
    this.ygk = getIntent().getStringExtra("key_group_solitatire_chatroom_username");
    this.scene = getIntent().getIntExtra("key_group_solitatire_scene", 3);
    int i;
    if ((this.scene == 3) || (dXZ()))
    {
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager();
      String str2 = this.ygk;
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getTempGroupSolitatireFromCache() username:%s key:%s", new Object[] { str2, str1 });
      paramBundle = (com.tencent.mm.plugin.groupsolitaire.c.a)paramBundle.yfg.get(str2 + str1);
      if (paramBundle != null) {
        break label214;
      }
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s temp == null", new Object[] { str1 });
      finish();
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label322;
      }
      AppMethodBeat.o(110461);
      return;
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ib(this.ygk, str1);
      break;
      label214:
      this.ygi = paramBundle.dXV();
      if (this.ygi == null)
      {
        Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s mGroupSolitatire == null", new Object[] { str1 });
        finish();
        i = 0;
      }
      else
      {
        this.ygj = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ib(this.ygk, this.ygi.field_key);
        this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.ygk);
        setResult(0);
        i = 1;
      }
    }
    label322:
    initView();
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
      if (!this.xfU) {
        amI();
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
    if (this.gyh != null) {
      this.gyh.close();
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
      dYc();
      AppMethodBeat.o(110479);
      return;
    }
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult failed");
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131763874), getString(2131763890), getString(2131762043), getString(2131763867), false, new GroupSolitatireEditUI.15(this), null);
    AppMethodBeat.o(110479);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110467);
    super.onResume();
    this.lTw.post(new Runnable()
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
    if ((this.scene == 2) || (dXY()) || (this.scene == 5)) {
      this.yfW.postDelayed(new Runnable()
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
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(110477);
    paramBoolean = this.xfU;
    if (paramInt > 0) {}
    for (this.xfU = true; (!paramBoolean) && (this.xfU); this.xfU = false)
    {
      localObject = this.ygo.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.ygg == 0) {
      this.ygg = paramInt;
    }
    if (this.ygl)
    {
      this.yfT.setMaxLines(b(this.yfT));
      this.yfY.setMaxLines(b(this.yfY));
    }
    if (this.yge != null)
    {
      if (!this.xfU) {
        this.yge.post(new Runnable()
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
      if (!this.xfU) {
        break label293;
      }
      if (this.yfZ.getTranslationY() != 0.0F) {
        this.yfZ.setTranslationY(0.0F);
      }
    }
    label293:
    for (Object localObject = ObjectAnimator.ofFloat(this.yfZ, "translationY", new float[] { this.yfZ.getTranslationY(), this.yfZ.getTranslationY() - this.ygg });; localObject = ObjectAnimator.ofFloat(this.yfZ, "translationY", new float[] { this.yfZ.getTranslationY(), this.yfZ.getTranslationY() + this.ygg }))
    {
      ((ObjectAnimator)localObject).setDuration(175L);
      ((ObjectAnimator)localObject).setInterpolator(new android.support.v4.view.b.b());
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
          if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).yfE.size() < com.tencent.mm.plugin.groupsolitaire.b.b.dXN()) {
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
      dYd();
      if (this.yge != null) {
        break label336;
      }
      AppMethodBeat.o(110477);
      return;
      this.yge.postDelayed(new Runnable()
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
    this.yge.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110441);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
        AppMethodBeat.o(110441);
      }
    }, 50L);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(this.xfU), Integer.valueOf(paramInt), Integer.valueOf(this.ygg) });
    AppMethodBeat.o(110477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI
 * JD-Core Version:    0.7.0.1
 */