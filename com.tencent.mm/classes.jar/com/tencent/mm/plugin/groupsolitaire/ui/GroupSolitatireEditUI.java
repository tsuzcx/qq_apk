package com.tencent.mm.plugin.groupsolitaire.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
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
  private GestureDetector aYl;
  private TextWatcher awu;
  private boolean diq;
  private ab fLO;
  private com.tencent.mm.ui.tools.h fQT;
  private ScrollView kLj;
  private TextView lDu;
  private RelativeLayout mWX;
  private boolean rzt;
  private int scene;
  private CdnImageView uBP;
  private MMEditText uBQ;
  private View uBR;
  private View uBS;
  private LinearLayout uBT;
  private ImageButton uBU;
  private MMEditText uBV;
  private LinearLayout uBW;
  private RelativeLayout uBX;
  private RelativeLayout uBY;
  private RelativeLayout uBZ;
  private View uCa;
  private View uCb;
  private boolean uCc;
  private int uCd;
  private int uCe;
  private com.tencent.mm.plugin.groupsolitaire.c.a uCf;
  private com.tencent.mm.plugin.groupsolitaire.c.a uCg;
  private String uCh;
  private boolean uCi;
  private boolean uCj;
  private boolean uCk;
  private boolean uCl;
  private ArrayList<View> uCm;
  private Rect uCn;
  private Rect uCo;
  private a uCp;
  private View.OnTouchListener uCq;
  
  public GroupSolitatireEditUI()
  {
    AppMethodBeat.i(110460);
    this.uCc = false;
    this.uCf = null;
    this.uCg = null;
    this.uCh = "";
    this.uCi = false;
    this.uCj = false;
    this.rzt = false;
    this.uCk = false;
    this.uCl = false;
    this.uCm = new ArrayList();
    this.diq = false;
    this.awu = new TextWatcher()
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
          String str = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).abd((String)localObject1);
          localObject1 = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            int j;
            ad.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
            continue;
            Object localObject2 = localObject1;
            if (j > com.tencent.mm.plugin.groupsolitaire.b.b.dbo() * 2)
            {
              i = com.tencent.mm.plugin.groupsolitaire.b.b.dR((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.dbo() * 2);
              paramAnonymousEditable.delete(i, ((String)localObject1).length());
              localObject2 = ((String)localObject1).substring(0, i);
            }
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).header = ((String)localObject2);
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).uBz = 1;
            continue;
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).uBy = ((String)localObject1);
            continue;
            com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131300641);
            if (localb != null)
            {
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.dbn() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.dR((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.dbn() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              localb.content = ((String)localObject2);
              continue;
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.dbp() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.dR((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.dbp() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).tUK = ((String)localObject2);
            }
          }
        }
        i = ((Integer)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131300643)).intValue();
        ad.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() str:%s type:%s", new Object[] { localObject1, Integer.valueOf(i) });
        j = com.tencent.mm.plugin.groupsolitaire.b.b.amR((String)localObject1);
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
          ad.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "startTime:%s interTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(110427);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.uCq = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110438);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (GroupSolitatireEditUI.f(GroupSolitatireEditUI.this))) {
          ((MMEditText)paramAnonymousView).setCursorVisible(true);
        }
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (((Integer)((MMEditText)paramAnonymousView).getTag(2131300643)).intValue() == 3) && (GroupSolitatireEditUI.g(GroupSolitatireEditUI.this))) {
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
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(110438);
        return false;
      }
    };
    AppMethodBeat.o(110460);
  }
  
  private void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.rzt = paramBoolean1;
    }
  }
  
  private boolean YM()
  {
    AppMethodBeat.i(110464);
    if (this.rzt) {
      com.tencent.mm.ui.base.h.a(this, getString(2131760092), "", getString(2131760091), getString(2131760090), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110429);
          ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot ok");
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          com.tencent.mm.plugin.groupsolitaire.b.d.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this), GroupSolitatireEditUI.o(GroupSolitatireEditUI.this), 2, GroupSolitatireEditUI.f(GroupSolitatireEditUI.this));
          GroupSolitatireEditUI.this.finish();
          AppMethodBeat.o(110429);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110430);
          ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot cancel");
          AppMethodBeat.o(110430);
        }
      }, 2131100798);
    }
    for (;;)
    {
      AppMethodBeat.o(110464);
      return true;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.uCf, dbw(), 1, this.uCi);
      finish();
    }
  }
  
  private void a(final MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110483);
    paramMMEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(215787);
        if ((paramAnonymousBoolean) && (GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) != null) && (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)))
        {
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215785);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
              AppMethodBeat.o(215785);
            }
          }, 200L);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215786);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(215786);
            }
          }, 200L);
          AppMethodBeat.o(215787);
          return;
        }
        paramMMEditText.setSelection(0);
        AppMethodBeat.o(215787);
      }
    });
    AppMethodBeat.o(110483);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(110481);
    ((MMEditText)this.uCb).requestFocus();
    this.uBT.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110443);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110443);
      }
    }, 200L);
    ((MMEditText)this.uCb).getText().insert(this.uCe, paramString + "; ");
    AppMethodBeat.o(110481);
  }
  
  private int b(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110484);
    if (this.uCd == 0)
    {
      AppMethodBeat.o(110484);
      return 10;
    }
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
    float f = paramMMEditText.getLineHeight();
    i = (int)((i - (this.uCd + this.uBW.getHeight() + com.tencent.mm.ui.aq.fromDPToPix(this, 145))) / f);
    AppMethodBeat.o(110484);
    return i;
  }
  
  private CharSequence bs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110472);
    com.tencent.mm.kernel.g.ajD();
    am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString);
    if ((paramBoolean) && (!bt.isNullOrNil(localam.field_conRemark))) {}
    for (String str = localam.field_conRemark;; str = uU(localam.field_username))
    {
      paramString = str;
      if (bt.isNullOrNil(str)) {
        paramString = localam.field_conRemark;
      }
      str = paramString;
      if (bt.isNullOrNil(paramString)) {
        str = localam.adu();
      }
      paramString = str;
      if (bt.isNullOrNil(str)) {
        paramString = localam.field_username;
      }
      paramString = k.c(getContext(), paramString);
      AppMethodBeat.o(110472);
      return paramString;
    }
  }
  
  private Pair<Boolean, Boolean> dbA()
  {
    boolean bool4 = false;
    AppMethodBeat.i(215792);
    Object localObject1 = new HashSet();
    int i = 1;
    while (i <= this.uCg.uBB.size())
    {
      localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)this.uCg.uBB.get(Integer.valueOf(i));
      if (bt.lQ(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).username, u.aAm())) {
        ((Set)localObject1).add(localObject2);
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    HashSet localHashSet = new HashSet();
    i = 1;
    while (i <= this.uCf.uBB.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.uCf.uBB.get(Integer.valueOf(i));
      if ((bt.lQ(localb.username, u.aAm())) && (!bt.isNullOrNil(localb.content.trim())))
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
      AppMethodBeat.o(215792);
      return localObject1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void dbB()
  {
    AppMethodBeat.i(110480);
    if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEr, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getResources().getString(2131760740, new Object[] { ac.fks() }), 30764, true);
          AppMethodBeat.o(110480);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        AppMethodBeat.o(110480);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(110480);
        return;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
    localIntent.putExtra("map_view_type", 3);
    com.tencent.mm.bs.d.b(this, "location", ".ui.RedirectUI", localIntent, 4097);
    AppMethodBeat.o(110480);
  }
  
  private void dbC()
  {
    AppMethodBeat.i(110482);
    if (this.mWX.findFocus() == null)
    {
      ad.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "mRootContainer.findFocus() is null");
      AppMethodBeat.o(110482);
      return;
    }
    this.uCb = this.mWX.findFocus();
    this.uCe = ((MMEditText)this.uCb).getSelectionStart();
    AppMethodBeat.o(110482);
  }
  
  private int dbw()
  {
    AppMethodBeat.i(110465);
    if (dbx())
    {
      AppMethodBeat.o(110465);
      return 3;
    }
    int i = this.scene;
    AppMethodBeat.o(110465);
    return i;
  }
  
  private boolean dbx()
  {
    return (this.scene == 3) || (this.scene == 4);
  }
  
  private boolean dby()
  {
    return (this.scene == 4) || (this.scene == 5);
  }
  
  private void dbz()
  {
    AppMethodBeat.i(110466);
    int j = 1;
    int i = 1;
    MMEditText localMMEditText;
    if (j <= this.uCf.uBB.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.uCf.uBB.get(Integer.valueOf(j));
      if (localb == null) {
        break label287;
      }
      View localView = getLayoutInflater().inflate(2131494425, null);
      ((TextView)localView.findViewById(2131300637)).setText(String.valueOf(i));
      localMMEditText = (MMEditText)localView.findViewById(2131300636);
      localMMEditText.setTag(2131300643, Integer.valueOf(3));
      localMMEditText.setTag(2131300641, localb);
      localMMEditText.setText(k.b(localMMEditText.getContext(), localb.content, (int)localMMEditText.getTextSize()));
      if (bt.lQ(localb.username, u.aAm()))
      {
        this.uCl = true;
        localMMEditText.requestFocus();
        localMMEditText.setFocusable(true);
        localMMEditText.setFocusableInTouchMode(true);
        localMMEditText.addTextChangedListener(this.awu);
        if (this.scene == 1) {
          localMMEditText.setCursorVisible(false);
        }
        label193:
        localMMEditText.setOnTouchListener(this.uCq);
        localMMEditText.setMaxLines(10);
        this.uBT.addView(localView);
        this.uCm.add(localView);
        a(localMMEditText);
        i += 1;
      }
    }
    label287:
    for (;;)
    {
      j += 1;
      break;
      this.uCl = false;
      localMMEditText.setTextColor(getResources().getColor(2131099676));
      localMMEditText.setKeyListener(null);
      localMMEditText.setTextIsSelectable(true);
      break label193;
      AppMethodBeat.o(110466);
      return;
    }
  }
  
  private void no(boolean paramBoolean)
  {
    AppMethodBeat.i(215791);
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    View localView = getLayoutInflater().inflate(2131494425, null);
    ((TextView)localView.findViewById(2131300637)).setText(this.uCf.uBB.size() + 1);
    MMEditText localMMEditText = (MMEditText)localView.findViewById(2131300636);
    CharSequence localCharSequence = bs(u.aAm(), false);
    if (!bt.ai(localCharSequence))
    {
      localMMEditText.setText(localCharSequence + " ");
      localb.content = String.valueOf(localCharSequence);
    }
    localb.username = u.aAm();
    localb.separator = this.uCf.separator;
    localb.uBF = (this.uCf.uBB.size() + 1);
    localMMEditText.setTag(2131300643, Integer.valueOf(3));
    localMMEditText.setTag(2131300641, localb);
    localMMEditText.requestFocus();
    localMMEditText.setFocusable(true);
    localMMEditText.setFocusableInTouchMode(true);
    localMMEditText.addTextChangedListener(this.awu);
    localMMEditText.setOnTouchListener(this.uCq);
    a(localMMEditText);
    localMMEditText.setMaxLines(10);
    this.uCf.uBB.put(Integer.valueOf(this.uCf.uBB.size() + 1), localb);
    this.uBT.addView(localView);
    this.uCm.add(localView);
    localView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110434);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110434);
      }
    });
    np(paramBoolean);
    AppMethodBeat.o(215791);
  }
  
  private void np(boolean paramBoolean)
  {
    AppMethodBeat.i(110475);
    int i = 1;
    Object localObject;
    if (i <= this.uCf.uBB.size())
    {
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)this.uCf.uBB.get(Integer.valueOf(i));
      if ((localObject == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content.trim()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (this.uCi)
      {
        if (i != 0)
        {
          enableOptionMenu(0, true);
          if (paramBoolean) {
            break label317;
          }
          if ((this.uCg != null) && (bt.lQ(this.uCf.header, this.uCg.header)) && (bt.lQ(this.uCf.uBy, this.uCg.uBy)) && (bt.lQ(this.uCf.tUK, this.uCg.tUK)))
          {
            localObject = dbA();
            bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
            bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
            if ((!bool1) && (!bool2))
            {
              T(false, paramBoolean);
              AppMethodBeat.o(110475);
              return;
              i += 1;
              break;
            }
          }
          T(true, paramBoolean);
          AppMethodBeat.o(110475);
          return;
        }
        enableOptionMenu(0, false);
        T(false, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      localObject = dbA();
      boolean bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
      boolean bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
      if ((i != 0) && ((bool1) || (bool2)))
      {
        enableOptionMenu(0, true);
        T(true, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      enableOptionMenu(0, false);
      T(false, paramBoolean);
      label317:
      AppMethodBeat.o(110475);
      return;
    }
  }
  
  private String uU(String paramString)
  {
    AppMethodBeat.i(110473);
    if (this.fLO == null)
    {
      AppMethodBeat.o(110473);
      return null;
    }
    paramString = this.fLO.zf(paramString);
    AppMethodBeat.o(110473);
    return paramString;
  }
  
  public final void Ii(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(110476);
    if ((this.uCb == null) || (!(this.uCb instanceof MMEditText)))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.uCf, paramInt, 0);
      AppMethodBeat.o(110476);
      return;
    }
    switch (((Integer)((MMEditText)this.uCb).getTag(2131300643)).intValue())
    {
    }
    for (;;)
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.uCf, paramInt, i);
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
    GestureDetector localGestureDetector = this.aYl;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "finish() hideVKB() %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(110469);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494426;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110463);
    super.initView();
    setMMTitle(getString(2131760115));
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131099679));
    setBackGroundColorResource(2131101179);
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
    this.fQT = new com.tencent.mm.ui.tools.h(getContext());
    this.fQT.KIP = this;
    this.kLj = ((ScrollView)findViewById(2131304251));
    this.mWX = ((RelativeLayout)findViewById(2131304241));
    this.uBP = ((CdnImageView)findViewById(2131300638));
    this.lDu = ((TextView)findViewById(2131300639));
    this.uBQ = ((MMEditText)findViewById(2131300644));
    this.uBR = findViewById(2131300650);
    this.uBS = findViewById(2131300651);
    this.uBT = ((LinearLayout)findViewById(2131300640));
    this.uBU = ((ImageButton)findViewById(2131300642));
    this.uBV = ((MMEditText)findViewById(2131300653));
    this.uBW = ((LinearLayout)findViewById(2131300645));
    this.uBX = ((RelativeLayout)findViewById(2131300646));
    this.uBY = ((RelativeLayout)findViewById(2131300647));
    this.uBZ = ((RelativeLayout)findViewById(2131300648));
    this.uCa = findViewById(2131300652);
    this.uBX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110450);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.j(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.this.Ii(2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110450);
      }
    });
    this.uBY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(110453);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new a(GroupSolitatireEditUI.this);
        paramAnonymousView.uBK = new a.a()
        {
          public final void amV(String paramAnonymous2String)
          {
            AppMethodBeat.i(110451);
            paramAnonymousView.hide();
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymous2String);
            GroupSolitatireEditUI.this.Ii(5);
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
        GroupSolitatireEditUI.this.Ii(4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110453);
      }
    });
    this.uBZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110455);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new b(GroupSolitatireEditUI.this);
        int i;
        int j;
        label135:
        int k;
        if (paramAnonymousView.uBM != null)
        {
          i = paramAnonymousView.uBM.getYear();
          if (paramAnonymousView.uBM == null) {
            break label311;
          }
          j = paramAnonymousView.uBM.getMonth();
          if (paramAnonymousView.uBM == null) {
            break label316;
          }
          k = paramAnonymousView.uBM.getDayOfMonth();
          label151:
          paramAnonymousView.uBN = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(110454);
              if (paramAnonymous2Boolean)
              {
                ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitaire time :%s", new Object[] { String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }) });
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, String.format(Locale.US, "%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }));
                GroupSolitatireEditUI.this.Ii(1);
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
          if (paramAnonymousView.uBM != null) {
            paramAnonymousView.uBM.setMinDate(((Calendar)localObject).getTimeInMillis());
          }
          localObject = Calendar.getInstance(Locale.US);
          ((Calendar)localObject).set(2029, 11, 31);
          if (paramAnonymousView.uBM != null) {
            paramAnonymousView.uBM.setMaxDate(((Calendar)localObject).getTimeInMillis());
          }
          if (paramAnonymousView.uBI != null)
          {
            if (paramAnonymousView.uBM != null) {
              paramAnonymousView.uBM.bFi();
            }
            paramAnonymousView.uBI.show();
          }
          GroupSolitatireEditUI.this.Ii(0);
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
          if (paramAnonymousView.uBM != null) {
            paramAnonymousView.uBM.a(i, j, k, null);
          }
        }
      }
    });
    addTextOptionMenu(0, getString(2131760107), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110458);
        ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "send group solitaire(sending:%s)", new Object[] { Boolean.valueOf(GroupSolitatireEditUI.k(GroupSolitatireEditUI.this)) });
        if (GroupSolitatireEditUI.k(GroupSolitatireEditUI.this))
        {
          AppMethodBeat.o(110458);
          return true;
        }
        com.tencent.mm.plugin.groupsolitaire.b.b.a(GroupSolitatireEditUI.l(GroupSolitatireEditUI.this), u.aAm(), GroupSolitatireEditUI.c(GroupSolitatireEditUI.this));
        if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).uBC) {
          com.tencent.mm.ui.base.h.e(GroupSolitatireEditUI.this.getContext(), GroupSolitatireEditUI.this.getString(2131760105), "", GroupSolitatireEditUI.this.getString(2131760104), GroupSolitatireEditUI.this.getString(2131760103), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110456);
              ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog ok");
              GroupSolitatireEditUI.m(GroupSolitatireEditUI.this);
              AppMethodBeat.o(110456);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110457);
              ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog cancel");
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
    }, null, s.b.JbS);
    Object localObject1;
    if (this.uCi)
    {
      enableOptionMenu(0, true);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110459);
          Bitmap localBitmap = com.tencent.mm.ak.c.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).field_creator, false, -1, null);
          if (localBitmap == null)
          {
            GroupSolitatireEditUI.n(GroupSolitatireEditUI.this).setImageResource(2131231875);
            AppMethodBeat.o(110459);
            return;
          }
          GroupSolitatireEditUI.n(GroupSolitatireEditUI.this).setImageBitmap(localBitmap);
          AppMethodBeat.o(110459);
        }
      };
      if (!com.tencent.mm.sdk.platformtools.aq.isMainThread()) {
        break label465;
      }
      ((Runnable)localObject1).run();
    }
    for (;;)
    {
      if (this.uCf.uBB.size() <= 0) {
        break label1477;
      }
      localObject1 = new HashSet();
      i = 1;
      while (i <= this.uCf.uBB.size())
      {
        ((Set)localObject1).add(((com.tencent.mm.plugin.groupsolitaire.c.b)this.uCf.uBB.get(Integer.valueOf(i))).username);
        i += 1;
      }
      enableOptionMenu(0, false);
      break;
      label465:
      com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110428);
          this.val$run.run();
          AppMethodBeat.o(110428);
        }
      });
    }
    label784:
    label923:
    label1066:
    label1091:
    label1477:
    for (int i = ((Set)localObject1).size();; i = 0)
    {
      this.lDu.setText(getString(2131760119, new Object[] { bs(this.uCf.field_creator, true), String.valueOf(i) }));
      Object localObject2;
      if ((!bt.isNullOrNil(this.uCf.header)) && (this.uCf.uBz == 1))
      {
        localObject2 = this.uCf.header;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.plugin.groupsolitaire.b.b.amR((String)localObject2) > com.tencent.mm.plugin.groupsolitaire.b.b.dbo() * 2)
          {
            localObject1 = ((String)localObject2).substring(0, com.tencent.mm.plugin.groupsolitaire.b.b.dR((String)localObject2, com.tencent.mm.plugin.groupsolitaire.b.b.dbo() * 2));
            this.uCf.header = ((String)localObject1);
          }
        }
        localObject1 = k.a(this.uBQ.getContext(), (CharSequence)localObject1, (int)this.uBQ.getTextSize(), 1);
        this.uBQ.setText((CharSequence)localObject1);
        if ((this.uCi) && (!bt.isNullOrNil(this.uCf.header)) && (this.uCf.uBz == 0))
        {
          this.uCf.uBz = 1;
          this.uCf.header = "";
          if ((this.uCf.uBB.size() > 0) && (((com.tencent.mm.plugin.groupsolitaire.c.b)this.uCf.uBB.get(Integer.valueOf(1))).uBE == 1)) {
            ((com.tencent.mm.plugin.groupsolitaire.c.b)this.uCf.uBB.get(Integer.valueOf(1))).uBE = 0;
          }
        }
        if (bt.isNullOrNil(this.uCf.tUK)) {
          break label1341;
        }
        localObject1 = k.a(this.uBV.getContext(), this.uCf.tUK, (int)this.uBV.getTextSize(), 1);
        this.uBV.setText((CharSequence)localObject1);
        if (!this.uCi) {
          break label1373;
        }
        this.uBQ.setFocusable(true);
        this.uBQ.setFocusableInTouchMode(true);
        this.uBQ.requestFocus();
        this.uBQ.setOnTouchListener(this.uCq);
        if (bt.isNullOrNil(this.uCf.header)) {
          this.uBQ.setHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 160));
        }
        this.uBQ.addTextChangedListener(this.awu);
        this.uBQ.setMaxLines(10);
        this.uBV.setFocusable(true);
        this.uBV.setFocusableInTouchMode(true);
        this.uBV.addTextChangedListener(this.awu);
        this.uBV.setOnTouchListener(this.uCq);
        this.uBV.setMaxLines(10);
        this.uBQ.setTag(2131300643, Integer.valueOf(1));
        this.uBV.setTag(2131300643, Integer.valueOf(4));
        if ((!bt.isNullOrNil(this.uCf.uBy)) || (this.uCi))
        {
          localObject1 = getLayoutInflater().inflate(2131494425, null);
          ((TextView)((View)localObject1).findViewById(2131300637)).setText(getString(2131760099));
          localObject2 = (MMEditText)((View)localObject1).findViewById(2131300636);
          ((MMEditText)localObject2).setTag(2131300643, Integer.valueOf(2));
          if (bt.isNullOrNil(this.uCf.uBy)) {
            break label1408;
          }
          ((MMEditText)localObject2).setText(k.b(((MMEditText)localObject2).getContext(), this.uCf.uBy, (int)((MMEditText)localObject2).getTextSize()));
          this.uCc = false;
          if (!this.uCi) {
            break label1423;
          }
          ((MMEditText)localObject2).setFocusable(true);
          ((MMEditText)localObject2).setFocusableInTouchMode(true);
          ((MMEditText)localObject2).addTextChangedListener(this.awu);
          ((MMEditText)localObject2).setOnTouchListener(this.uCq);
          ((MMEditText)localObject2).setMaxLines(10);
          this.uBT.addView((View)localObject1);
        }
        dbz();
        if (this.uCf.uBB.size() < com.tencent.mm.plugin.groupsolitaire.b.b.dbm()) {
          this.uBU.setOnClickListener(new GroupSolitatireEditUI.5(this));
        }
        if ((this.scene != 2) && ((!dbx()) || (this.uCf.uBD <= 0)) && (this.scene != 5)) {
          break label1450;
        }
        no(true);
        if ((this.uCi) && (dby())) {
          this.uBQ.requestFocus();
        }
      }
      for (;;)
      {
        if (this.uCi) {
          this.uCg = this.uCf.dbu();
        }
        dbC();
        np(true);
        a(this.uBV);
        a(this.uBQ);
        this.aYl = new GestureDetector(this, new GestureDetector.OnGestureListener()
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
            AppMethodBeat.i(215790);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(215790);
          }
          
          public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            AppMethodBeat.i(215788);
            if (!GroupSolitatireEditUI.u(GroupSolitatireEditUI.this)) {
              GroupSolitatireEditUI.this.hideVKB();
            }
            AppMethodBeat.o(215788);
            return false;
          }
          
          public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(215789);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(215789);
            return false;
          }
        });
        this.uCn = new Rect();
        this.uCo = new Rect();
        AppMethodBeat.o(110463);
        return;
        if (!this.uCi)
        {
          this.uBQ.setVisibility(8);
          this.uBR.setVisibility(8);
          break;
        }
        this.uBQ.setHint(2131760117);
        break;
        if (!this.uCi)
        {
          this.uBV.setVisibility(8);
          break label784;
        }
        this.uBV.setHint(2131760108);
        break label784;
        label1373:
        this.uBQ.setKeyListener(null);
        this.uBQ.setTextIsSelectable(true);
        this.uBV.setKeyListener(null);
        this.uBV.setTextIsSelectable(true);
        break label923;
        ((MMEditText)localObject2).setHint(2131760098);
        this.uCc = true;
        break label1066;
        ((MMEditText)localObject2).setTextColor(getResources().getColor(2131099676));
        ((MMEditText)localObject2).setKeyListener(null);
        ((MMEditText)localObject2).setTextIsSelectable(true);
        break label1091;
        if (this.scene == 1) {
          this.kLj.post(new Runnable()
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
    ((MMEditText)this.uCb).requestFocus();
    ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      String str1 = bt.bI(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      String str2 = paramIntent.getStringExtra("kPoiName");
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_LOC address: %s, poiName：%s", new Object[] { str1, str2 });
      paramIntent = str1;
      if (str1.contains(getString(2131760086))) {
        paramIntent = str1.substring(str1.indexOf(getString(2131760086)) + 1);
      }
      amW(str2 + "(" + paramIntent + ")");
      Ii(3);
      AppMethodBeat.o(110478);
      return;
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_CONTACT");
      if (this.uCp != null) {
        this.uCp.show();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110461);
    super.onCreate(paramBundle);
    this.uCi = getIntent().getBooleanExtra("key_group_solitatire_create", false);
    String str1 = getIntent().getStringExtra("key_group_solitatire_key");
    this.uCh = getIntent().getStringExtra("key_group_solitatire_chatroom_username");
    this.scene = getIntent().getIntExtra("key_group_solitatire_scene", 3);
    int i;
    if ((this.scene == 3) || (dby()))
    {
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager();
      String str2 = this.uCh;
      ad.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getTempGroupSolitatireFromCache() username:%s key:%s", new Object[] { str2, str1 });
      paramBundle = (com.tencent.mm.plugin.groupsolitaire.c.a)paramBundle.uBd.get(str2 + str1);
      if (paramBundle != null) {
        break label212;
      }
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s temp == null", new Object[] { str1 });
      finish();
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label319;
      }
      AppMethodBeat.o(110461);
      return;
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hn(this.uCh, str1);
      break;
      label212:
      this.uCf = paramBundle.dbu();
      if (this.uCf == null)
      {
        ad.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s mGroupSolitatire == null", new Object[] { str1 });
        finish();
        i = 0;
      }
      else
      {
        this.uCg = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hn(this.uCh, this.uCf.field_key);
        this.fLO = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.uCh);
        setResult(0);
        i = 1;
      }
    }
    label319:
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
      if (!this.uCj) {
        YM();
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
    if (this.fQT != null) {
      this.fQT.close();
    }
    AppMethodBeat.o(110468);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110479);
    ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(110479);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult OK");
      dbB();
      AppMethodBeat.o(110479);
      return;
    }
    ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult failed");
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761863), false, new GroupSolitatireEditUI.15(this), null);
    AppMethodBeat.o(110479);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110467);
    super.onResume();
    this.kLj.post(new Runnable()
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
    if ((this.scene == 2) || (dbx()) || (this.scene == 5)) {
      this.uBT.postDelayed(new Runnable()
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
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(110477);
    paramBoolean = this.uCj;
    if (paramInt > 0) {}
    for (this.uCj = true; (!paramBoolean) && (this.uCj); this.uCj = false)
    {
      localObject = this.uCm.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.uCd == 0) {
      this.uCd = paramInt;
    }
    if (this.uCi)
    {
      this.uBQ.setMaxLines(b(this.uBQ));
      this.uBV.setMaxLines(b(this.uBV));
    }
    if (this.uCb != null)
    {
      if (!this.uCj) {
        this.uCb.post(new Runnable()
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
      if (!this.uCj) {
        break label293;
      }
      if (this.uBW.getTranslationY() != 0.0F) {
        this.uBW.setTranslationY(0.0F);
      }
    }
    label293:
    for (Object localObject = ObjectAnimator.ofFloat(this.uBW, "translationY", new float[] { this.uBW.getTranslationY(), this.uBW.getTranslationY() - this.uCd });; localObject = ObjectAnimator.ofFloat(this.uBW, "translationY", new float[] { this.uBW.getTranslationY(), this.uBW.getTranslationY() + this.uCd }))
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
          if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).uBB.size() < com.tencent.mm.plugin.groupsolitaire.b.b.dbm()) {
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
      dbC();
      if (this.uCb != null) {
        break label336;
      }
      AppMethodBeat.o(110477);
      return;
      this.uCb.postDelayed(new Runnable()
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
    this.uCb.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110441);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
        AppMethodBeat.o(110441);
      }
    }, 50L);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(this.uCj), Integer.valueOf(paramInt), Integer.valueOf(this.uCd) });
    AppMethodBeat.o(110477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI
 * JD-Core Version:    0.7.0.1
 */