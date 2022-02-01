package com.tencent.mm.plugin.groupsolitaire.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.a;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.b.e;
import com.tencent.mm.plugin.groupsolitaire.b.f;
import com.tencent.mm.plugin.groupsolitaire.b.g;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GroupSolitatireEditUI
  extends MMActivity
  implements com.tencent.mm.ui.tools.h
{
  private boolean Ake;
  private boolean HDO;
  private RelativeLayout JjC;
  private CdnImageView JjD;
  private MMEditText JjE;
  private View JjF;
  private View JjG;
  private LinearLayout JjH;
  private ImageButton JjI;
  private MMEditText JjJ;
  private LinearLayout JjK;
  private RelativeLayout JjL;
  private RelativeLayout JjM;
  private RelativeLayout JjN;
  private View JjO;
  private boolean JjP;
  private int JjQ;
  private int JjR;
  private com.tencent.mm.plugin.groupsolitaire.c.a JjS;
  private com.tencent.mm.plugin.groupsolitaire.c.a JjT;
  private String JjU;
  private boolean JjV;
  private boolean JjW;
  private boolean JjX;
  private ArrayList<View> JjY;
  private Rect JjZ;
  private Rect Jka;
  private a Jkb;
  private View.OnTouchListener Jkc;
  private GestureDetector detector;
  private boolean hxI;
  private i lKz;
  private aj lzy;
  private TextView pJi;
  private ScrollView pLK;
  private View pLL;
  private int scene;
  private TextWatcher vU;
  
  public GroupSolitatireEditUI()
  {
    AppMethodBeat.i(110460);
    this.JjP = false;
    this.JjS = null;
    this.JjT = null;
    this.JjU = "";
    this.JjV = false;
    this.HDO = false;
    this.Ake = false;
    this.JjW = false;
    this.JjX = false;
    this.JjY = new ArrayList();
    this.hxI = false;
    this.vU = new TextWatcher()
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
          String str = ((com.tencent.mm.plugin.emoji.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.a.class)).anH((String)localObject1);
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
            if (j > com.tencent.mm.plugin.groupsolitaire.b.b.fJp() * 2)
            {
              i = com.tencent.mm.plugin.groupsolitaire.b.b.fD((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.fJp() * 2);
              paramAnonymousEditable.delete(i, paramAnonymousEditable.length());
              localObject2 = ((String)localObject1).substring(0, i);
            }
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).header = ((String)localObject2);
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).Jjm = 1;
            continue;
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).Jjl = ((String)localObject1);
            continue;
            com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(b.e.JhW);
            if (localb != null)
            {
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.fJo() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.fD((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.fJo() * 2);
                paramAnonymousEditable.delete(i, paramAnonymousEditable.length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              localb.content = ((String)localObject2);
              continue;
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.fJq() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.fD((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.fJq() * 2);
                paramAnonymousEditable.delete(i, paramAnonymousEditable.length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).IvM = ((String)localObject2);
            }
          }
        }
        i = ((Integer)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(b.e.JhY)).intValue();
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() str:%s type:%s", new Object[] { localObject1, Integer.valueOf(i) });
        j = com.tencent.mm.plugin.groupsolitaire.b.b.aHQ((String)localObject1);
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
    this.Jkc = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110438);
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (GroupSolitatireEditUI.f(GroupSolitatireEditUI.this))) {
          ((MMEditText)paramAnonymousView).setCursorVisible(true);
        }
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (((Integer)((MMEditText)paramAnonymousView).getTag(b.e.JhY)).intValue() == 3) && (GroupSolitatireEditUI.g(GroupSolitatireEditUI.this))) {
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
  
  private String Dd(String paramString)
  {
    AppMethodBeat.i(110473);
    if (this.lzy == null)
    {
      AppMethodBeat.o(110473);
      return null;
    }
    paramString = this.lzy.getDisplayName(paramString);
    AppMethodBeat.o(110473);
    return paramString;
  }
  
  private void aHV(String paramString)
  {
    AppMethodBeat.i(110481);
    ((MMEditText)this.JjO).requestFocus();
    this.JjH.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110443);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110443);
      }
    }, 200L);
    ((MMEditText)this.JjO).getText().insert(this.JjR, paramString + "; ");
    AppMethodBeat.o(110481);
  }
  
  private boolean aML()
  {
    AppMethodBeat.i(110464);
    if (this.Ake) {
      k.a(this, getString(b.g.Jiv), "", getString(b.g.Jiu), getString(b.g.Jit), false, new DialogInterface.OnClickListener()new GroupSolitatireEditUI.4
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110429);
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot ok");
          ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this), GroupSolitatireEditUI.o(GroupSolitatireEditUI.this), 2, GroupSolitatireEditUI.f(GroupSolitatireEditUI.this));
          GroupSolitatireEditUI.this.finish();
          AppMethodBeat.o(110429);
        }
      }, new GroupSolitatireEditUI.4(this), b.b.red);
    }
    for (;;)
    {
      AppMethodBeat.o(110464);
      return true;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      d.a(this.JjS, fJx(), 1, this.JjV);
      finish();
    }
  }
  
  private void aw(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.Ake = paramBoolean1;
    }
  }
  
  private void b(final MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110483);
    paramMMEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(262658);
        if ((paramAnonymousBoolean) && (GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) != null) && (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)))
        {
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(262672);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
              AppMethodBeat.o(262672);
            }
          }, 200L);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(262671);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(262671);
            }
          }, 200L);
          AppMethodBeat.o(262658);
          return;
        }
        paramMMEditText.setSelection(0);
        AppMethodBeat.o(262658);
      }
    });
    AppMethodBeat.o(110483);
  }
  
  private int c(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110484);
    if (this.JjQ == 0)
    {
      AppMethodBeat.o(110484);
      return 10;
    }
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
    float f1 = paramMMEditText.getLineHeight();
    float f2 = (i - (this.JjQ + this.JjK.getHeight() + bd.fromDPToPix(this, 145))) / f1;
    f1 = f2;
    if (f2 <= 0.0F) {
      f1 = 10.0F;
    }
    i = (int)f1;
    AppMethodBeat.o(110484);
    return i;
  }
  
  private CharSequence ck(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110472);
    com.tencent.mm.kernel.h.baF();
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if ((paramBoolean) && (!Util.isNullOrNil(localau.field_conRemark))) {}
    for (String str = localau.field_conRemark;; str = Dd(localau.field_username))
    {
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = localau.field_conRemark;
      }
      str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = localau.aSU();
      }
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = localau.field_username;
      }
      paramString = p.b(getContext(), paramString);
      AppMethodBeat.o(110472);
      return paramString;
    }
  }
  
  private void fJA()
  {
    AppMethodBeat.i(110466);
    int j = 1;
    int i = 1;
    MMEditText localMMEditText;
    if (j <= this.JjS.Jjo.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.JjS.Jjo.get(Integer.valueOf(j));
      if (localb == null) {
        break label287;
      }
      View localView = getLayoutInflater().inflate(b.f.Jim, null);
      ((TextView)localView.findViewById(b.e.JhS)).setText(String.valueOf(i));
      localMMEditText = (MMEditText)localView.findViewById(b.e.JhR);
      localMMEditText.setTag(b.e.JhY, Integer.valueOf(3));
      localMMEditText.setTag(b.e.JhW, localb);
      localMMEditText.setText(p.d(localMMEditText.getContext(), localb.content, (int)localMMEditText.getTextSize()));
      if (Util.isEqual(localb.username, z.bAM()))
      {
        this.JjX = true;
        localMMEditText.requestFocus();
        localMMEditText.setFocusable(true);
        localMMEditText.setFocusableInTouchMode(true);
        localMMEditText.addTextChangedListener(this.vU);
        if (this.scene == 1) {
          localMMEditText.setCursorVisible(false);
        }
        label193:
        localMMEditText.setOnTouchListener(this.Jkc);
        localMMEditText.setMaxLines(10);
        this.JjH.addView(localView);
        this.JjY.add(localView);
        b(localMMEditText);
        i += 1;
      }
    }
    label287:
    for (;;)
    {
      j += 1;
      break;
      this.JjX = false;
      localMMEditText.setTextColor(getResources().getColor(b.b.BW_50));
      localMMEditText.setKeyListener(null);
      localMMEditText.setTextIsSelectable(true);
      break label193;
      AppMethodBeat.o(110466);
      return;
    }
  }
  
  private Pair<Boolean, Boolean> fJB()
  {
    boolean bool4 = false;
    AppMethodBeat.i(262681);
    Object localObject1 = new HashSet();
    int i = 1;
    while (i <= this.JjT.Jjo.size())
    {
      localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)this.JjT.Jjo.get(Integer.valueOf(i));
      if (Util.isEqual(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).username, z.bAM())) {
        ((Set)localObject1).add(localObject2);
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    HashSet localHashSet = new HashSet();
    i = 1;
    while (i <= this.JjS.Jjo.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.JjS.Jjo.get(Integer.valueOf(i));
      if ((Util.isEqual(localb.username, z.bAM())) && (!Util.isNullOrNil(localb.content.trim())))
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
      AppMethodBeat.o(262681);
      return localObject1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void fJC()
  {
    AppMethodBeat.i(110480);
    if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.s(this, "android.permission.ACCESS_FINE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.sdk.c.a.b(this, getResources().getString(b.g.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
          AppMethodBeat.o(110480);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
        AppMethodBeat.o(110480);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, null);
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(110480);
        return;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideExitAnimation", b.a.push_down_out);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", b.a.fast_faded_in);
    localIntent.putExtra("map_view_type", 3);
    com.tencent.mm.br.c.b(this, "location", ".ui.RedirectUI", localIntent, 4097);
    AppMethodBeat.o(110480);
  }
  
  private void fJD()
  {
    AppMethodBeat.i(110482);
    if (this.JjC.findFocus() == null)
    {
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "mRootContainer.findFocus() is null");
      AppMethodBeat.o(110482);
      return;
    }
    this.JjO = this.JjC.findFocus();
    this.JjR = ((MMEditText)this.JjO).getSelectionStart();
    AppMethodBeat.o(110482);
  }
  
  private int fJx()
  {
    AppMethodBeat.i(110465);
    if (fJy())
    {
      AppMethodBeat.o(110465);
      return 3;
    }
    int i = this.scene;
    AppMethodBeat.o(110465);
    return i;
  }
  
  private boolean fJy()
  {
    return (this.scene == 3) || (this.scene == 4);
  }
  
  private boolean fJz()
  {
    return (this.scene == 4) || (this.scene == 5);
  }
  
  private void wF(boolean paramBoolean)
  {
    AppMethodBeat.i(262673);
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    View localView = getLayoutInflater().inflate(b.f.Jim, null);
    ((TextView)localView.findViewById(b.e.JhS)).setText(this.JjS.Jjo.size() + 1);
    MMEditText localMMEditText = (MMEditText)localView.findViewById(b.e.JhR);
    CharSequence localCharSequence = ck(z.bAM(), false);
    if (!Util.isNullOrNil(localCharSequence))
    {
      localMMEditText.setText(localCharSequence + " ");
      localb.content = String.valueOf(localCharSequence);
    }
    localb.username = z.bAM();
    localb.dIC = this.JjS.dIC;
    localb.Jjs = (this.JjS.Jjo.size() + 1);
    localMMEditText.setTag(b.e.JhY, Integer.valueOf(3));
    localMMEditText.setTag(b.e.JhW, localb);
    localMMEditText.requestFocus();
    localMMEditText.setFocusable(true);
    localMMEditText.setFocusableInTouchMode(true);
    localMMEditText.addTextChangedListener(this.vU);
    localMMEditText.setOnTouchListener(this.Jkc);
    b(localMMEditText);
    localMMEditText.setMaxLines(10);
    this.JjS.Jjo.put(Integer.valueOf(this.JjS.Jjo.size() + 1), localb);
    this.JjH.addView(localView);
    this.JjY.add(localView);
    localView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110434);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110434);
      }
    });
    wG(paramBoolean);
    AppMethodBeat.o(262673);
  }
  
  private void wG(boolean paramBoolean)
  {
    AppMethodBeat.i(110475);
    int i = 1;
    Object localObject;
    if (i <= this.JjS.Jjo.size())
    {
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)this.JjS.Jjo.get(Integer.valueOf(i));
      if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content.trim()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (this.JjV)
      {
        if (i != 0)
        {
          enableOptionMenu(0, true);
          if (paramBoolean) {
            break label317;
          }
          if ((this.JjT != null) && (Util.isEqual(this.JjS.header, this.JjT.header)) && (Util.isEqual(this.JjS.Jjl, this.JjT.Jjl)) && (Util.isEqual(this.JjS.IvM, this.JjT.IvM)))
          {
            localObject = fJB();
            bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
            bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
            if ((!bool1) && (!bool2))
            {
              aw(false, paramBoolean);
              AppMethodBeat.o(110475);
              return;
              i += 1;
              break;
            }
          }
          aw(true, paramBoolean);
          AppMethodBeat.o(110475);
          return;
        }
        enableOptionMenu(0, false);
        aw(false, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      localObject = fJB();
      boolean bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
      boolean bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
      if ((i != 0) && ((bool1) || (bool2)))
      {
        enableOptionMenu(0, true);
        aw(true, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      enableOptionMenu(0, false);
      aw(false, paramBoolean);
      label317:
      AppMethodBeat.o(110475);
      return;
    }
  }
  
  public final void Ye(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(110476);
    if ((this.JjO == null) || (!(this.JjO instanceof MMEditText)))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      d.a(this.JjS, paramInt, 0);
      AppMethodBeat.o(110476);
      return;
    }
    switch (((Integer)((MMEditText)this.JjO).getTag(b.e.JhY)).intValue())
    {
    }
    for (;;)
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      d.a(this.JjS, paramInt, i);
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
    GestureDetector localGestureDetector = this.detector;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
    return b.f.Jin;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110463);
    super.initView();
    setMMTitle(getString(b.g.JiH));
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.b.BW_93));
    setBackGroundColorResource(b.b.white);
    setBackBtn(new GroupSolitatireEditUI.20(this));
    this.lKz = new i(getContext());
    this.lKz.afIL = this;
    this.pLK = ((ScrollView)findViewById(b.e.root_view));
    this.JjC = ((RelativeLayout)findViewById(b.e.root_container));
    this.JjD = ((CdnImageView)findViewById(b.e.JhT));
    this.pJi = ((TextView)findViewById(b.e.JhU));
    this.JjE = ((MMEditText)findViewById(b.e.JhZ));
    this.JjF = findViewById(b.e.Jie);
    this.JjG = findViewById(b.e.Jif);
    this.JjH = ((LinearLayout)findViewById(b.e.JhV));
    this.JjI = ((ImageButton)findViewById(b.e.JhX));
    this.JjJ = ((MMEditText)findViewById(b.e.Jih));
    this.JjK = ((LinearLayout)findViewById(b.e.Jia));
    this.JjL = ((RelativeLayout)findViewById(b.e.Jib));
    this.JjM = ((RelativeLayout)findViewById(b.e.Jic));
    this.JjN = ((RelativeLayout)findViewById(b.e.Jid));
    this.pLL = findViewById(b.e.Jig);
    this.JjL.setOnClickListener(new GroupSolitatireEditUI.22(this));
    this.JjM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(110453);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new a(GroupSolitatireEditUI.this);
        paramAnonymousView.Jjx = new a.a()
        {
          public final void aHU(String paramAnonymous2String)
          {
            AppMethodBeat.i(110451);
            paramAnonymousView.hide();
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymous2String);
            GroupSolitatireEditUI.this.Ye(5);
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
        GroupSolitatireEditUI.this.Ye(4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110453);
      }
    });
    this.JjN.setOnClickListener(new GroupSolitatireEditUI.24(this));
    addTextOptionMenu(0, getString(b.g.JiD), new GroupSolitatireEditUI.25(this), null, y.b.adEJ);
    Object localObject1;
    if (this.JjV)
    {
      enableOptionMenu(0, true);
      localObject1 = new GroupSolitatireEditUI.26(this);
      if (!MMHandlerThread.isMainThread()) {
        break label465;
      }
      ((Runnable)localObject1).run();
    }
    for (;;)
    {
      if (this.JjS.Jjo.size() <= 0) {
        break label1483;
      }
      localObject1 = new HashSet();
      i = 1;
      while (i <= this.JjS.Jjo.size())
      {
        ((Set)localObject1).add(((com.tencent.mm.plugin.groupsolitaire.c.b)this.JjS.Jjo.get(Integer.valueOf(i))).username);
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
      this.pJi.setText(getString(b.g.JiJ, new Object[] { ck(this.JjS.field_creator, true), String.valueOf(i) }));
      Object localObject2;
      if ((!Util.isNullOrNil(this.JjS.header)) && (this.JjS.Jjm == 1))
      {
        localObject2 = this.JjS.header;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aHQ((String)localObject2) > com.tencent.mm.plugin.groupsolitaire.b.b.fJp() * 2)
          {
            localObject1 = ((String)localObject2).substring(0, com.tencent.mm.plugin.groupsolitaire.b.b.fD((String)localObject2, com.tencent.mm.plugin.groupsolitaire.b.b.fJp() * 2));
            this.JjS.header = ((String)localObject1);
          }
        }
        localObject2 = this.JjE.getContext();
        this.JjE.getTextSize();
        localObject1 = p.e((Context)localObject2, (CharSequence)localObject1, 1);
        this.JjE.setText((CharSequence)localObject1);
        if ((this.JjV) && (!Util.isNullOrNil(this.JjS.header)) && (this.JjS.Jjm == 0))
        {
          this.JjS.Jjm = 1;
          this.JjS.header = "";
          if ((this.JjS.Jjo.size() > 0) && (((com.tencent.mm.plugin.groupsolitaire.c.b)this.JjS.Jjo.get(Integer.valueOf(1))).Jjr == 1)) {
            ((com.tencent.mm.plugin.groupsolitaire.c.b)this.JjS.Jjo.get(Integer.valueOf(1))).Jjr = 0;
          }
        }
        if (Util.isNullOrNil(this.JjS.IvM)) {
          break label1347;
        }
        localObject1 = this.JjJ.getContext();
        localObject2 = this.JjS.IvM;
        this.JjJ.getTextSize();
        localObject1 = p.e((Context)localObject1, (CharSequence)localObject2, 1);
        this.JjJ.setText((CharSequence)localObject1);
        if (!this.JjV) {
          break label1379;
        }
        this.JjE.setFocusable(true);
        this.JjE.setFocusableInTouchMode(true);
        this.JjE.requestFocus();
        this.JjE.setOnTouchListener(this.Jkc);
        if (Util.isNullOrNil(this.JjS.header)) {
          this.JjE.setHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 160));
        }
        this.JjE.addTextChangedListener(this.vU);
        this.JjE.setMaxLines(10);
        this.JjJ.setFocusable(true);
        this.JjJ.setFocusableInTouchMode(true);
        this.JjJ.addTextChangedListener(this.vU);
        this.JjJ.setOnTouchListener(this.Jkc);
        this.JjJ.setMaxLines(10);
        this.JjE.setTag(b.e.JhY, Integer.valueOf(1));
        this.JjJ.setTag(b.e.JhY, Integer.valueOf(4));
        if ((!Util.isNullOrNil(this.JjS.Jjl)) || (this.JjV))
        {
          localObject1 = getLayoutInflater().inflate(b.f.Jim, null);
          ((TextView)((View)localObject1).findViewById(b.e.JhS)).setText(getString(b.g.Jiy));
          localObject2 = (MMEditText)((View)localObject1).findViewById(b.e.JhR);
          ((MMEditText)localObject2).setTag(b.e.JhY, Integer.valueOf(2));
          if (Util.isNullOrNil(this.JjS.Jjl)) {
            break label1414;
          }
          ((MMEditText)localObject2).setText(p.d(((MMEditText)localObject2).getContext(), this.JjS.Jjl, (int)((MMEditText)localObject2).getTextSize()));
          this.JjP = false;
          if (!this.JjV) {
            break label1429;
          }
          ((MMEditText)localObject2).setFocusable(true);
          ((MMEditText)localObject2).setFocusableInTouchMode(true);
          ((MMEditText)localObject2).addTextChangedListener(this.vU);
          ((MMEditText)localObject2).setOnTouchListener(this.Jkc);
          ((MMEditText)localObject2).setMaxLines(10);
          this.JjH.addView((View)localObject1);
        }
        fJA();
        if (this.JjS.Jjo.size() < com.tencent.mm.plugin.groupsolitaire.b.b.fJn()) {
          this.JjI.setOnClickListener(new GroupSolitatireEditUI.5(this));
        }
        if ((this.scene != 2) && ((!fJy()) || (this.JjS.Jjq <= 0)) && (this.scene != 5)) {
          break label1456;
        }
        wF(true);
        if ((this.JjV) && (fJz())) {
          this.JjE.requestFocus();
        }
      }
      for (;;)
      {
        if (this.JjV) {
          this.JjT = this.JjS.fJv();
        }
        fJD();
        wG(true);
        b(this.JjJ);
        b(this.JjE);
        this.detector = new GestureDetector(this, new GroupSolitatireEditUI.19(this));
        this.JjZ = new Rect();
        this.Jka = new Rect();
        AppMethodBeat.o(110463);
        return;
        if (!this.JjV)
        {
          this.JjE.setVisibility(8);
          this.JjF.setVisibility(8);
          break;
        }
        this.JjE.setHint(b.g.JiI);
        break;
        if (!this.JjV)
        {
          this.JjJ.setVisibility(8);
          break label790;
        }
        this.JjJ.setHint(b.g.JiE);
        break label790;
        label1379:
        this.JjE.setKeyListener(null);
        this.JjE.setTextIsSelectable(true);
        this.JjJ.setKeyListener(null);
        this.JjJ.setTextIsSelectable(true);
        break label929;
        ((MMEditText)localObject2).setHint(b.g.Jix);
        this.JjP = true;
        break label1072;
        ((MMEditText)localObject2).setTextColor(getResources().getColor(b.b.BW_50));
        ((MMEditText)localObject2).setKeyListener(null);
        ((MMEditText)localObject2).setTextIsSelectable(true);
        break label1097;
        if (this.scene == 1) {
          this.pLK.post(new GroupSolitatireEditUI.21(this));
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(110478);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((MMEditText)this.JjO).requestFocus();
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
      if (str1.contains(getString(b.g.Jiq))) {
        paramIntent = str1.substring(str1.indexOf(getString(b.g.Jiq)) + 1);
      }
      aHV(str2 + "(" + paramIntent + ")");
      Ye(3);
      AppMethodBeat.o(110478);
      return;
      Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_CONTACT");
      if (this.Jkb != null) {
        this.Jkb.show();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110461);
    super.onCreate(paramBundle);
    this.JjV = getIntent().getBooleanExtra("key_group_solitatire_create", false);
    String str1 = getIntent().getStringExtra("key_group_solitatire_key");
    this.JjU = getIntent().getStringExtra("key_group_solitatire_chatroom_username");
    this.scene = getIntent().getIntExtra("key_group_solitatire_scene", 3);
    int i;
    if ((this.scene == 3) || (fJz()))
    {
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager();
      String str2 = this.JjU;
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getTempGroupSolitatireFromCache() username:%s key:%s", new Object[] { str2, str1 });
      paramBundle = (com.tencent.mm.plugin.groupsolitaire.c.a)paramBundle.JiR.get(str2 + str1);
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
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jr(this.JjU, str1);
      break;
      label213:
      this.JjS = paramBundle.fJv();
      if (this.JjS == null)
      {
        Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s mGroupSolitatire == null", new Object[] { str1 });
        finish();
        i = 0;
      }
      else
      {
        this.JjT = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jr(this.JjU, this.JjS.field_key);
        this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.JjU);
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
      if (!this.HDO) {
        aML();
      }
      AppMethodBeat.o(110462);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(110462);
    return bool;
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(110477);
    paramBoolean = this.HDO;
    if (paramInt > 0) {}
    for (this.HDO = true; (!paramBoolean) && (this.HDO); this.HDO = false)
    {
      localObject = this.JjY.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (paramInt != 0) {
      this.JjQ = paramInt;
    }
    if (this.JjV)
    {
      this.JjE.setMaxLines(c(this.JjE));
      this.JjJ.setMaxLines(c(this.JjJ));
    }
    if (this.JjO != null)
    {
      if (!this.HDO) {
        this.JjO.post(new Runnable()
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
      if (!this.HDO) {
        break label277;
      }
      if (this.JjK.getTranslationY() != 0.0F) {
        this.JjK.setTranslationY(0.0F);
      }
    }
    label277:
    for (Object localObject = ObjectAnimator.ofFloat(this.JjK, "translationY", new float[] { 0.0F, -this.JjQ });; localObject = ObjectAnimator.ofFloat(this.JjK, "translationY", new float[] { this.JjK.getTranslationY(), 0.0F }))
    {
      ((ObjectAnimator)localObject).setDuration(175L);
      ((ObjectAnimator)localObject).setInterpolator(new androidx.g.a.a.b());
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
          if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).Jjo.size() < com.tencent.mm.plugin.groupsolitaire.b.b.fJn()) {
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
      fJD();
      if (this.JjO != null) {
        break label308;
      }
      AppMethodBeat.o(110477);
      return;
      this.JjO.postDelayed(new Runnable()
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
    label308:
    this.JjO.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110441);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
        AppMethodBeat.o(110441);
      }
    }, 50L);
    Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(this.HDO), Integer.valueOf(paramInt), Integer.valueOf(this.JjQ) });
    AppMethodBeat.o(110477);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110468);
    super.onPause();
    if (this.lKz != null) {
      this.lKz.close();
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
      fJC();
      AppMethodBeat.o(110479);
      return;
    }
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult failed");
    k.a(getContext(), getString(b.g.permission_location_request_again_msg), getString(b.g.permission_tips_title), getString(b.g.jump_to_settings), getString(b.g.permission_dialog_cancel), false, new GroupSolitatireEditUI.15(this), null);
    AppMethodBeat.o(110479);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110467);
    super.onResume();
    this.pLK.post(new Runnable()
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
    if ((this.scene == 2) || (fJy()) || (this.scene == 5)) {
      this.JjH.postDelayed(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI
 * JD-Core Version:    0.7.0.1
 */