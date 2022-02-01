package com.tencent.mm.plugin.groupsolitaire.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GroupSolitatireEditUI
  extends MMActivity
  implements com.tencent.mm.ui.tools.g
{
  private GestureDetector aNb;
  private TextWatcher atH;
  private boolean cZE;
  private w fql;
  private com.tencent.mm.ui.tools.h ftZ;
  private ScrollView jPx;
  private TextView kFd;
  private RelativeLayout lUq;
  private boolean qgS;
  private int scene;
  private View srA;
  private View srB;
  private boolean srC;
  private int srD;
  private int srE;
  private com.tencent.mm.plugin.groupsolitaire.c.a srF;
  private com.tencent.mm.plugin.groupsolitaire.c.a srG;
  private String srH;
  private boolean srI;
  private boolean srJ;
  private boolean srK;
  private boolean srL;
  private ArrayList<View> srM;
  private Rect srN;
  private Rect srO;
  private a srP;
  private View.OnTouchListener srQ;
  private CdnImageView srp;
  private MMEditText srq;
  private View srr;
  private View srs;
  private LinearLayout srt;
  private ImageButton sru;
  private MMEditText srv;
  private LinearLayout srw;
  private RelativeLayout srx;
  private RelativeLayout sry;
  private RelativeLayout srz;
  
  public GroupSolitatireEditUI()
  {
    AppMethodBeat.i(110460);
    this.srC = false;
    this.srF = null;
    this.srG = null;
    this.srH = "";
    this.srI = false;
    this.srJ = false;
    this.qgS = false;
    this.srK = false;
    this.srL = false;
    this.srM = new ArrayList();
    this.cZE = false;
    this.atH = new TextWatcher()
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
          String str = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Tk((String)localObject1);
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
            if (j > com.tencent.mm.plugin.groupsolitaire.b.b.cEY() * 2)
            {
              i = com.tencent.mm.plugin.groupsolitaire.b.b.du((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.cEY() * 2);
              paramAnonymousEditable.delete(i, ((String)localObject1).length());
              localObject2 = ((String)localObject1).substring(0, i);
            }
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).header = ((String)localObject2);
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).sqY = 1;
            continue;
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).sqW = ((String)localObject1);
            continue;
            com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131300641);
            if (localb != null)
            {
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.cEX() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.du((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.cEX() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              localb.content = ((String)localObject2);
              continue;
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.cEZ() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.du((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.cEZ() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).sqX = ((String)localObject2);
            }
          }
        }
        i = ((Integer)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131300643)).intValue();
        ad.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() str:%s type:%s", new Object[] { localObject1, Integer.valueOf(i) });
        j = com.tencent.mm.plugin.groupsolitaire.b.b.adm((String)localObject1);
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
    this.srQ = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110438);
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
        AppMethodBeat.o(110438);
        return false;
      }
    };
    AppMethodBeat.o(110460);
  }
  
  private void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.qgS = paramBoolean1;
    }
  }
  
  private boolean Vv()
  {
    AppMethodBeat.i(110464);
    if (this.qgS) {
      com.tencent.mm.ui.base.h.a(this, getString(2131760092), "", getString(2131760091), getString(2131760090), false, new DialogInterface.OnClickListener()new GroupSolitatireEditUI.4
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
      }, new GroupSolitatireEditUI.4(this), 2131100798);
    }
    for (;;)
    {
      AppMethodBeat.o(110464);
      return true;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.srF, cFf(), 1, this.srI);
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
        AppMethodBeat.i(192545);
        if ((paramAnonymousBoolean) && (GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) != null) && (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)))
        {
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192543);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
              AppMethodBeat.o(192543);
            }
          }, 200L);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192544);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(192544);
            }
          }, 200L);
          AppMethodBeat.o(192545);
          return;
        }
        paramMMEditText.setSelection(0);
        AppMethodBeat.o(192545);
      }
    });
    AppMethodBeat.o(110483);
  }
  
  private void adr(String paramString)
  {
    AppMethodBeat.i(110481);
    ((MMEditText)this.srB).requestFocus();
    this.srt.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110443);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110443);
      }
    }, 200L);
    ((MMEditText)this.srB).getText().insert(this.srE, paramString + "; ");
    AppMethodBeat.o(110481);
  }
  
  private int b(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110484);
    if (this.srD == 0)
    {
      AppMethodBeat.o(110484);
      return 10;
    }
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
    float f = paramMMEditText.getLineHeight();
    i = (int)((i - (this.srD + this.srw.getHeight() + ao.fromDPToPix(this, 145))) / f);
    AppMethodBeat.o(110484);
    return i;
  }
  
  private CharSequence bf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110472);
    com.tencent.mm.kernel.g.afC();
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((paramBoolean) && (!bt.isNullOrNil(localaf.field_conRemark))) {}
    for (String str = localaf.field_conRemark;; str = oS(localaf.field_username))
    {
      paramString = str;
      if (bt.isNullOrNil(str)) {
        paramString = localaf.field_conRemark;
      }
      str = paramString;
      if (bt.isNullOrNil(paramString)) {
        str = localaf.ZW();
      }
      paramString = str;
      if (bt.isNullOrNil(str)) {
        paramString = localaf.field_username;
      }
      paramString = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), paramString);
      AppMethodBeat.o(110472);
      return paramString;
    }
  }
  
  private int cFf()
  {
    AppMethodBeat.i(110465);
    if (cFg())
    {
      AppMethodBeat.o(110465);
      return 3;
    }
    int i = this.scene;
    AppMethodBeat.o(110465);
    return i;
  }
  
  private boolean cFg()
  {
    return (this.scene == 3) || (this.scene == 4);
  }
  
  private boolean cFh()
  {
    return (this.scene == 4) || (this.scene == 5);
  }
  
  private void cFi()
  {
    AppMethodBeat.i(110466);
    int j = 1;
    int i = 1;
    MMEditText localMMEditText;
    if (j <= this.srF.sra.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.srF.sra.get(Integer.valueOf(j));
      if (localb == null) {
        break label287;
      }
      View localView = getLayoutInflater().inflate(2131494425, null);
      ((TextView)localView.findViewById(2131300637)).setText(String.valueOf(i));
      localMMEditText = (MMEditText)localView.findViewById(2131300636);
      localMMEditText.setTag(2131300643, Integer.valueOf(3));
      localMMEditText.setTag(2131300641, localb);
      localMMEditText.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localMMEditText.getContext(), localb.content, (int)localMMEditText.getTextSize()));
      if (bt.kU(localb.username, u.aqG()))
      {
        this.srL = true;
        localMMEditText.requestFocus();
        localMMEditText.setFocusable(true);
        localMMEditText.setFocusableInTouchMode(true);
        localMMEditText.addTextChangedListener(this.atH);
        if (this.scene == 1) {
          localMMEditText.setCursorVisible(false);
        }
        label193:
        localMMEditText.setOnTouchListener(this.srQ);
        localMMEditText.setMaxLines(10);
        this.srt.addView(localView);
        this.srM.add(localView);
        a(localMMEditText);
        i += 1;
      }
    }
    label287:
    for (;;)
    {
      j += 1;
      break;
      this.srL = false;
      localMMEditText.setTextColor(getResources().getColor(2131099676));
      localMMEditText.setKeyListener(null);
      localMMEditText.setTextIsSelectable(true);
      break label193;
      AppMethodBeat.o(110466);
      return;
    }
  }
  
  private Pair<Boolean, Boolean> cFj()
  {
    boolean bool4 = false;
    AppMethodBeat.i(192548);
    Object localObject1 = new HashSet();
    int i = 1;
    while (i <= this.srG.sra.size())
    {
      localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)this.srG.sra.get(Integer.valueOf(i));
      if (bt.kU(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).username, u.aqG())) {
        ((Set)localObject1).add(localObject2);
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    HashSet localHashSet = new HashSet();
    i = 1;
    while (i <= this.srF.sra.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.srF.sra.get(Integer.valueOf(i));
      if ((bt.kU(localb.username, u.aqG())) && (!bt.isNullOrNil(localb.content.trim())))
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
      AppMethodBeat.o(192548);
      return localObject1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void cFk()
  {
    AppMethodBeat.i(110480);
    if (com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtT, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getResources().getString(2131760740, new Object[] { ac.eFu() }), 30764, true);
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
  
  private void cFl()
  {
    AppMethodBeat.i(110482);
    if (this.lUq.findFocus() == null)
    {
      ad.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "mRootContainer.findFocus() is null");
      AppMethodBeat.o(110482);
      return;
    }
    this.srB = this.lUq.findFocus();
    this.srE = ((MMEditText)this.srB).getSelectionStart();
    AppMethodBeat.o(110482);
  }
  
  private void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(192547);
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    View localView = getLayoutInflater().inflate(2131494425, null);
    ((TextView)localView.findViewById(2131300637)).setText(this.srF.sra.size() + 1);
    MMEditText localMMEditText = (MMEditText)localView.findViewById(2131300636);
    CharSequence localCharSequence = bf(u.aqG(), false);
    if (!bt.ai(localCharSequence))
    {
      localMMEditText.setText(localCharSequence + " ");
      localb.content = String.valueOf(localCharSequence);
    }
    localb.username = u.aqG();
    localb.separator = this.srF.separator;
    localb.srf = (this.srF.sra.size() + 1);
    localMMEditText.setTag(2131300643, Integer.valueOf(3));
    localMMEditText.setTag(2131300641, localb);
    localMMEditText.requestFocus();
    localMMEditText.setFocusable(true);
    localMMEditText.setFocusableInTouchMode(true);
    localMMEditText.addTextChangedListener(this.atH);
    localMMEditText.setOnTouchListener(this.srQ);
    a(localMMEditText);
    localMMEditText.setMaxLines(10);
    this.srF.sra.put(Integer.valueOf(this.srF.sra.size() + 1), localb);
    this.srt.addView(localView);
    this.srM.add(localView);
    localView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110434);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110434);
      }
    });
    mc(paramBoolean);
    AppMethodBeat.o(192547);
  }
  
  private void mc(boolean paramBoolean)
  {
    AppMethodBeat.i(110475);
    int i = 1;
    Object localObject;
    if (i <= this.srF.sra.size())
    {
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)this.srF.sra.get(Integer.valueOf(i));
      if ((localObject == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content.trim()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (this.srI)
      {
        if (i != 0)
        {
          enableOptionMenu(0, true);
          if (paramBoolean) {
            break label317;
          }
          if ((this.srG != null) && (bt.kU(this.srF.header, this.srG.header)) && (bt.kU(this.srF.sqW, this.srG.sqW)) && (bt.kU(this.srF.sqX, this.srG.sqX)))
          {
            localObject = cFj();
            bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
            bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
            if ((!bool1) && (!bool2))
            {
              N(false, paramBoolean);
              AppMethodBeat.o(110475);
              return;
              i += 1;
              break;
            }
          }
          N(true, paramBoolean);
          AppMethodBeat.o(110475);
          return;
        }
        enableOptionMenu(0, false);
        N(false, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      localObject = cFj();
      boolean bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
      boolean bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
      if ((i != 0) && ((bool1) || (bool2)))
      {
        enableOptionMenu(0, true);
        N(true, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      enableOptionMenu(0, false);
      N(false, paramBoolean);
      label317:
      AppMethodBeat.o(110475);
      return;
    }
  }
  
  private String oS(String paramString)
  {
    AppMethodBeat.i(110473);
    if (this.fql == null)
    {
      AppMethodBeat.o(110473);
      return null;
    }
    paramString = this.fql.sh(paramString);
    AppMethodBeat.o(110473);
    return paramString;
  }
  
  public final void EQ(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(110476);
    if ((this.srB == null) || (!(this.srB instanceof MMEditText)))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.srF, paramInt, 0);
      AppMethodBeat.o(110476);
      return;
    }
    switch (((Integer)((MMEditText)this.srB).getTag(2131300643)).intValue())
    {
    }
    for (;;)
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.srF, paramInt, i);
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
    this.aNb.onTouchEvent(paramMotionEvent);
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
    setBackBtn(new GroupSolitatireEditUI.20(this));
    this.ftZ = new com.tencent.mm.ui.tools.h(getContext());
    this.ftZ.Hro = this;
    this.jPx = ((ScrollView)findViewById(2131304251));
    this.lUq = ((RelativeLayout)findViewById(2131304241));
    this.srp = ((CdnImageView)findViewById(2131300638));
    this.kFd = ((TextView)findViewById(2131300639));
    this.srq = ((MMEditText)findViewById(2131300644));
    this.srr = findViewById(2131300650);
    this.srs = findViewById(2131300651);
    this.srt = ((LinearLayout)findViewById(2131300640));
    this.sru = ((ImageButton)findViewById(2131300642));
    this.srv = ((MMEditText)findViewById(2131300653));
    this.srw = ((LinearLayout)findViewById(2131300645));
    this.srx = ((RelativeLayout)findViewById(2131300646));
    this.sry = ((RelativeLayout)findViewById(2131300647));
    this.srz = ((RelativeLayout)findViewById(2131300648));
    this.srA = findViewById(2131300652);
    this.srx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110450);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.j(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.this.EQ(2);
        AppMethodBeat.o(110450);
      }
    });
    this.sry.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(110453);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new a(GroupSolitatireEditUI.this);
        paramAnonymousView.srk = new a.a()
        {
          public final void adq(String paramAnonymous2String)
          {
            AppMethodBeat.i(110451);
            paramAnonymousView.hide();
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymous2String);
            GroupSolitatireEditUI.this.EQ(5);
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
        GroupSolitatireEditUI.this.EQ(4);
        AppMethodBeat.o(110453);
      }
    });
    this.srz.setOnClickListener(new GroupSolitatireEditUI.24(this));
    addTextOptionMenu(0, getString(2131760107), new GroupSolitatireEditUI.25(this), null, r.b.FOB);
    Object localObject1;
    if (this.srI)
    {
      enableOptionMenu(0, true);
      localObject1 = new GroupSolitatireEditUI.26(this);
      if (!aq.isMainThread()) {
        break label465;
      }
      ((Runnable)localObject1).run();
    }
    for (;;)
    {
      if (this.srF.sra.size() <= 0) {
        break label1477;
      }
      localObject1 = new HashSet();
      i = 1;
      while (i <= this.srF.sra.size())
      {
        ((Set)localObject1).add(((com.tencent.mm.plugin.groupsolitaire.c.b)this.srF.sra.get(Integer.valueOf(i))).username);
        i += 1;
      }
      enableOptionMenu(0, false);
      break;
      label465:
      aq.f(new GroupSolitatireEditUI.2(this, (Runnable)localObject1));
    }
    label784:
    label923:
    label1066:
    label1091:
    label1477:
    for (int i = ((Set)localObject1).size();; i = 0)
    {
      this.kFd.setText(getString(2131760119, new Object[] { bf(this.srF.field_creator, true), String.valueOf(i) }));
      Object localObject2;
      if ((!bt.isNullOrNil(this.srF.header)) && (this.srF.sqY == 1))
      {
        localObject2 = this.srF.header;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.plugin.groupsolitaire.b.b.adm((String)localObject2) > com.tencent.mm.plugin.groupsolitaire.b.b.cEY() * 2)
          {
            localObject1 = ((String)localObject2).substring(0, com.tencent.mm.plugin.groupsolitaire.b.b.du((String)localObject2, com.tencent.mm.plugin.groupsolitaire.b.b.cEY() * 2));
            this.srF.header = ((String)localObject1);
          }
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(this.srq.getContext(), (CharSequence)localObject1, (int)this.srq.getTextSize(), 1);
        this.srq.setText((CharSequence)localObject1);
        if ((this.srI) && (!bt.isNullOrNil(this.srF.header)) && (this.srF.sqY == 0))
        {
          this.srF.sqY = 1;
          this.srF.header = "";
          if ((this.srF.sra.size() > 0) && (((com.tencent.mm.plugin.groupsolitaire.c.b)this.srF.sra.get(Integer.valueOf(1))).sre == 1)) {
            ((com.tencent.mm.plugin.groupsolitaire.c.b)this.srF.sra.get(Integer.valueOf(1))).sre = 0;
          }
        }
        if (bt.isNullOrNil(this.srF.sqX)) {
          break label1341;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(this.srv.getContext(), this.srF.sqX, (int)this.srv.getTextSize(), 1);
        this.srv.setText((CharSequence)localObject1);
        if (!this.srI) {
          break label1373;
        }
        this.srq.setFocusable(true);
        this.srq.setFocusableInTouchMode(true);
        this.srq.requestFocus();
        this.srq.setOnTouchListener(this.srQ);
        if (bt.isNullOrNil(this.srF.header)) {
          this.srq.setHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 160));
        }
        this.srq.addTextChangedListener(this.atH);
        this.srq.setMaxLines(10);
        this.srv.setFocusable(true);
        this.srv.setFocusableInTouchMode(true);
        this.srv.addTextChangedListener(this.atH);
        this.srv.setOnTouchListener(this.srQ);
        this.srv.setMaxLines(10);
        this.srq.setTag(2131300643, Integer.valueOf(1));
        this.srv.setTag(2131300643, Integer.valueOf(4));
        if ((!bt.isNullOrNil(this.srF.sqW)) || (this.srI))
        {
          localObject1 = getLayoutInflater().inflate(2131494425, null);
          ((TextView)((View)localObject1).findViewById(2131300637)).setText(getString(2131760099));
          localObject2 = (MMEditText)((View)localObject1).findViewById(2131300636);
          ((MMEditText)localObject2).setTag(2131300643, Integer.valueOf(2));
          if (bt.isNullOrNil(this.srF.sqW)) {
            break label1408;
          }
          ((MMEditText)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.k.b(((MMEditText)localObject2).getContext(), this.srF.sqW, (int)((MMEditText)localObject2).getTextSize()));
          this.srC = false;
          if (!this.srI) {
            break label1423;
          }
          ((MMEditText)localObject2).setFocusable(true);
          ((MMEditText)localObject2).setFocusableInTouchMode(true);
          ((MMEditText)localObject2).addTextChangedListener(this.atH);
          ((MMEditText)localObject2).setOnTouchListener(this.srQ);
          ((MMEditText)localObject2).setMaxLines(10);
          this.srt.addView((View)localObject1);
        }
        cFi();
        if (this.srF.sra.size() < com.tencent.mm.plugin.groupsolitaire.b.b.cEW()) {
          this.sru.setOnClickListener(new GroupSolitatireEditUI.5(this));
        }
        if ((this.scene != 2) && ((!cFg()) || (this.srF.srd <= 0)) && (this.scene != 5)) {
          break label1450;
        }
        mb(true);
        if ((this.srI) && (cFh())) {
          this.srq.requestFocus();
        }
      }
      for (;;)
      {
        if (this.srI) {
          this.srG = this.srF.cFd();
        }
        cFl();
        mc(true);
        a(this.srv);
        a(this.srq);
        this.aNb = new GestureDetector(this, new GestureDetector.OnGestureListener()
        {
          public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
          
          public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            return false;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
          
          public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            AppMethodBeat.i(192546);
            if (!GroupSolitatireEditUI.u(GroupSolitatireEditUI.this)) {
              GroupSolitatireEditUI.this.hideVKB();
            }
            AppMethodBeat.o(192546);
            return false;
          }
          
          public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
        });
        this.srN = new Rect();
        this.srO = new Rect();
        AppMethodBeat.o(110463);
        return;
        if (!this.srI)
        {
          this.srq.setVisibility(8);
          this.srr.setVisibility(8);
          break;
        }
        this.srq.setHint(2131760117);
        break;
        if (!this.srI)
        {
          this.srv.setVisibility(8);
          break label784;
        }
        this.srv.setHint(2131760108);
        break label784;
        label1373:
        this.srq.setKeyListener(null);
        this.srq.setTextIsSelectable(true);
        this.srv.setKeyListener(null);
        this.srv.setTextIsSelectable(true);
        break label923;
        ((MMEditText)localObject2).setHint(2131760098);
        this.srC = true;
        break label1066;
        ((MMEditText)localObject2).setTextColor(getResources().getColor(2131099676));
        ((MMEditText)localObject2).setKeyListener(null);
        ((MMEditText)localObject2).setTextIsSelectable(true);
        break label1091;
        if (this.scene == 1) {
          this.jPx.post(new Runnable()
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
    ((MMEditText)this.srB).requestFocus();
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
      String str1 = bt.by(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      String str2 = paramIntent.getStringExtra("kPoiName");
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_LOC address: %s, poiName：%s", new Object[] { str1, str2 });
      paramIntent = str1;
      if (str1.contains(getString(2131760086))) {
        paramIntent = str1.substring(str1.indexOf(getString(2131760086)) + 1);
      }
      adr(str2 + "(" + paramIntent + ")");
      EQ(3);
      AppMethodBeat.o(110478);
      return;
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_CONTACT");
      if (this.srP != null) {
        this.srP.show();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110461);
    super.onCreate(paramBundle);
    this.srI = getIntent().getBooleanExtra("key_group_solitatire_create", false);
    String str1 = getIntent().getStringExtra("key_group_solitatire_key");
    this.srH = getIntent().getStringExtra("key_group_solitatire_chatroom_username");
    this.scene = getIntent().getIntExtra("key_group_solitatire_scene", 3);
    int i;
    if ((this.scene == 3) || (cFh()))
    {
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager();
      String str2 = this.srH;
      ad.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getTempGroupSolitatireFromCache() username:%s key:%s", new Object[] { str2, str1 });
      paramBundle = (com.tencent.mm.plugin.groupsolitaire.c.a)paramBundle.sqB.get(str2 + str1);
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
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gK(this.srH, str1);
      break;
      label212:
      this.srF = paramBundle.cFd();
      if (this.srF == null)
      {
        ad.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s mGroupSolitatire == null", new Object[] { str1 });
        finish();
        i = 0;
      }
      else
      {
        this.srG = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gK(this.srH, this.srF.field_key);
        this.fql = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.srH);
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
      if (!this.srJ) {
        Vv();
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
    if (this.ftZ != null) {
      this.ftZ.close();
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
      cFk();
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
    this.jPx.post(new Runnable()
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
    if ((this.scene == 2) || (cFg()) || (this.scene == 5)) {
      this.srt.postDelayed(new Runnable()
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
    paramBoolean = this.srJ;
    if (paramInt > 0) {}
    for (this.srJ = true; (!paramBoolean) && (this.srJ); this.srJ = false)
    {
      localObject = this.srM.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.srD == 0) {
      this.srD = paramInt;
    }
    if (this.srI)
    {
      this.srq.setMaxLines(b(this.srq));
      this.srv.setMaxLines(b(this.srv));
    }
    if (this.srB != null)
    {
      if (!this.srJ) {
        this.srB.post(new Runnable()
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
      if (!this.srJ) {
        break label293;
      }
      if (this.srw.getTranslationY() != 0.0F) {
        this.srw.setTranslationY(0.0F);
      }
    }
    label293:
    for (Object localObject = ObjectAnimator.ofFloat(this.srw, "translationY", new float[] { this.srw.getTranslationY(), this.srw.getTranslationY() - this.srD });; localObject = ObjectAnimator.ofFloat(this.srw, "translationY", new float[] { this.srw.getTranslationY(), this.srw.getTranslationY() + this.srD }))
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
          if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).sra.size() < com.tencent.mm.plugin.groupsolitaire.b.b.cEW()) {
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
      cFl();
      if (this.srB != null) {
        break label336;
      }
      AppMethodBeat.o(110477);
      return;
      this.srB.postDelayed(new Runnable()
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
    this.srB.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110441);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
        AppMethodBeat.o(110441);
      }
    }, 50L);
    ad.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(this.srJ), Integer.valueOf(paramInt), Integer.valueOf(this.srD) });
    AppMethodBeat.o(110477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI
 * JD-Core Version:    0.7.0.1
 */