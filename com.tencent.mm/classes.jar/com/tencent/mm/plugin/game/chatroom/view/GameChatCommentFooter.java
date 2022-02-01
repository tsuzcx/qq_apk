package com.tencent.mm.plugin.game.chatroom.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.autogen.chatroom.Channel;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.c;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.plugin.game.chatroom.ui.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.pluginsdk.ui.chat.m.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.c;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameChatCommentFooter
  extends InputPanelLinearLayout
{
  private TextView DcK;
  private int IqA;
  private int IqB;
  private boolean IqC;
  public boolean IqD;
  private b IqE;
  public Map<String, List<String>> IqF;
  private String IqG;
  private boolean IqH;
  private String IqI;
  private String IqJ;
  private a IqK;
  private boolean IqL;
  private Channel IqM;
  private boolean IqN;
  private com.tencent.mm.ui.widget.a.j IqO;
  private m.a IqP;
  private ViewGroup Iqu;
  private TextView Iqv;
  private ImageView Iqw;
  private boolean Iqx;
  public m Iqy;
  private int Iqz;
  private MMActivity lzt;
  public ChatFooterPanel moD;
  public MMEditText nir;
  private TextView nis;
  private ImageView nit;
  private int niw;
  private boolean nix;
  private int sNb;
  public int state;
  
  public GameChatCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276213);
    this.Iqx = false;
    this.state = -1;
    this.Iqz = -1;
    this.IqA = -1;
    this.sNb = 0;
    this.IqB = 0;
    this.IqC = false;
    this.niw = 0;
    this.nix = false;
    this.IqD = false;
    this.IqF = new HashMap();
    this.IqG = "";
    this.IqH = false;
    this.IqJ = "";
    this.IqK = new a();
    this.IqL = false;
    this.IqN = false;
    this.IqP = new GameChatCommentFooter.22(this);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(276213);
  }
  
  private void fDv()
  {
    AppMethodBeat.i(276237);
    this.IqC = false;
    this.lzt.hideVKB();
    AppMethodBeat.o(276237);
  }
  
  private void fDw()
  {
    AppMethodBeat.i(276248);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { 0, this.IqB });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(276444);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        Log.d("GameChatRoom.GameChatCommentFooter", "showSmileyAnim value:%d", new Object[] { Integer.valueOf(i) });
        paramAnonymousValueAnimator = (LinearLayout.LayoutParams)GameChatCommentFooter.c(GameChatCommentFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.height = i;
        GameChatCommentFooter.c(GameChatCommentFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(276444);
      }
    });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(276436);
        GameChatCommentFooter.c(GameChatCommentFooter.this).setVisibility(0);
        GameChatCommentFooter.a(GameChatCommentFooter.this, 0);
        AppMethodBeat.o(276436);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(276429);
        GameChatCommentFooter.c(GameChatCommentFooter.this).setVisibility(0);
        GameChatCommentFooter.a(GameChatCommentFooter.this, 0);
        AppMethodBeat.o(276429);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(276248);
  }
  
  private void fDx()
  {
    AppMethodBeat.i(276256);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.IqB, 0 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(276431);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        Log.d("GameChatRoom.GameChatCommentFooter", "hideSmileyAnim value:%d", new Object[] { Integer.valueOf(i) });
        paramAnonymousValueAnimator = (LinearLayout.LayoutParams)GameChatCommentFooter.c(GameChatCommentFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.height = i;
        GameChatCommentFooter.c(GameChatCommentFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(276431);
      }
    });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(276435);
        GameChatCommentFooter.c(GameChatCommentFooter.this).setVisibility(8);
        paramAnonymousAnimator = (LinearLayout.LayoutParams)GameChatCommentFooter.c(GameChatCommentFooter.this).getLayoutParams();
        paramAnonymousAnimator.height = GameChatCommentFooter.o(GameChatCommentFooter.this);
        GameChatCommentFooter.c(GameChatCommentFooter.this).setLayoutParams(paramAnonymousAnimator);
        GameChatCommentFooter.a(GameChatCommentFooter.this, 8);
        AppMethodBeat.o(276435);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(276426);
        GameChatCommentFooter.c(GameChatCommentFooter.this).setVisibility(0);
        AppMethodBeat.o(276426);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(276256);
  }
  
  private void fDy()
  {
    AppMethodBeat.i(276266);
    this.IqB = Math.max(getResources().getDimensionPixelSize(h.c.Iez), this.sNb);
    Log.printDebugStack("GameChatRoom.GameChatCommentFooter", "keyboardHeight:%d, smileyPanelHeight:%d", new Object[] { Integer.valueOf(this.sNb), Integer.valueOf(this.IqB) });
    AppMethodBeat.o(276266);
  }
  
  private long getSourceId()
  {
    AppMethodBeat.i(276277);
    long l = this.lzt.getIntent().getLongExtra("game_report_sourceid", 0L);
    AppMethodBeat.o(276277);
    return l;
  }
  
  private long getSsid()
  {
    AppMethodBeat.i(276272);
    long l = this.lzt.getIntent().getLongExtra("game_report_ssid", 0L);
    AppMethodBeat.o(276272);
    return l;
  }
  
  private void setFooterVisibilityImpl(int paramInt)
  {
    AppMethodBeat.i(276228);
    super.setVisibility(paramInt);
    Object localObject;
    label101:
    label119:
    int i;
    if ((paramInt == 0) && (this.Iqu != null))
    {
      localObject = this.Iqu;
      if (!this.IqK.hBY) {
        break label236;
      }
      paramInt = 0;
      ((ViewGroup)localObject).setVisibility(paramInt);
      this.Iqu.setTag(this.IqK.IqV);
      TextView localTextView = this.Iqv;
      if (this.IqK.IqV == null) {
        break label242;
      }
      localObject = "话题：" + this.IqK.IqV.name;
      localTextView.setText((CharSequence)localObject);
      if (!this.IqK.IqU) {
        break label248;
      }
      paramInt = 0;
      i = paramInt;
      if (this.IqM != null)
      {
        i = paramInt;
        if (!com.tencent.mm.plugin.game.chatroom.g.a.Xd(this.IqM.channel_id)) {
          i = 8;
        }
      }
      this.Iqw.setVisibility(i);
      if ((!this.IqK.hBY) || (this.IqM == null) || (com.tencent.mm.plugin.game.chatroom.g.a.Xd(this.IqM.channel_id))) {
        break label254;
      }
      this.moD.Jy(false);
      this.moD.setShowStore(false);
      this.moD.setShowSearch(false);
    }
    for (;;)
    {
      this.moD.onResume();
      if (i == 0) {
        this.IqK.b(false, null, false);
      }
      AppMethodBeat.o(276228);
      return;
      label236:
      paramInt = 8;
      break;
      label242:
      localObject = "";
      break label101;
      label248:
      paramInt = 8;
      break label119;
      label254:
      this.moD.setShowStore(true);
      this.moD.setShowSearch(true);
      if (this.IqL) {
        this.moD.Jy(true);
      }
    }
  }
  
  private void wh(boolean paramBoolean)
  {
    AppMethodBeat.i(276220);
    if (this.moD == null)
    {
      AppMethodBeat.o(276220);
      return;
    }
    Log.printInfoStack("GameChatRoom.GameChatCommentFooter", "showState ".concat(String.valueOf(paramBoolean)), new Object[0]);
    if (!paramBoolean)
    {
      wi(this.Iqx);
      fDv();
      requestLayout();
      AppMethodBeat.o(276220);
      return;
    }
    this.nit.performClick();
    this.Iqx = false;
    AppMethodBeat.o(276220);
  }
  
  private void wi(final boolean paramBoolean)
  {
    AppMethodBeat.i(276243);
    this.moD.onPause();
    if (KeyBoardUtil.isPortOrientation(getContext()))
    {
      getInputPanelHelper().be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(276176);
          if (paramBoolean) {
            GameChatCommentFooter.d(GameChatCommentFooter.this);
          }
          AppMethodBeat.o(276176);
        }
      });
      AppMethodBeat.o(276243);
      return;
    }
    if (paramBoolean) {
      fDx();
    }
    AppMethodBeat.o(276243);
  }
  
  public final void a(String paramString, Channel paramChannel)
  {
    AppMethodBeat.i(276518);
    if (paramChannel != null) {
      a(true, paramChannel, true);
    }
    if (g.a(this.nir.getText().toString() + paramString, com.tencent.mm.ui.tools.g.a.afII) <= 1000) {
      this.nir.bDt(paramString);
    }
    AppMethodBeat.o(276518);
  }
  
  public final void a(boolean paramBoolean1, Channel paramChannel, boolean paramBoolean2)
  {
    AppMethodBeat.i(276548);
    if (paramBoolean1)
    {
      if (paramChannel != null)
      {
        this.IqK.b(true, paramChannel, paramBoolean2);
        AppMethodBeat.o(276548);
      }
    }
    else {
      this.IqK.b(false, null, false);
    }
    AppMethodBeat.o(276548);
  }
  
  public char getCharAtCursor()
  {
    AppMethodBeat.i(276526);
    int i = getSelectionStart();
    if (i <= 0)
    {
      AppMethodBeat.o(276526);
      return 'x';
    }
    char c = getLastText().charAt(i - 1);
    AppMethodBeat.o(276526);
    return c;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(276535);
    if (this.nir == null)
    {
      AppMethodBeat.o(276535);
      return "";
    }
    String str = this.nir.getText().toString();
    AppMethodBeat.o(276535);
    return str;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(276531);
    int i = this.nir.getSelectionStart();
    AppMethodBeat.o(276531);
    return i;
  }
  
  public final void jf(final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276501);
    this.state = paramInt2;
    final boolean bool;
    if (paramInt1 == 0)
    {
      bool = true;
      this.Iqx = false;
      if ((this.state != 0) || (!bool)) {
        break label73;
      }
    }
    for (this.Iqx = true;; this.Iqx = true) {
      label73:
      do
      {
        wh(bool);
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276443);
            GameChatCommentFooter.a(GameChatCommentFooter.this, paramInt1);
            if (GameChatCommentFooter.a(GameChatCommentFooter.this) != null) {
              GameChatCommentFooter.a(GameChatCommentFooter.this).wg(bool);
            }
            AppMethodBeat.o(276443);
          }
        }, 100L);
        AppMethodBeat.o(276501);
        return;
        bool = false;
        break;
      } while ((this.state != 1) || (bool));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(276556);
    if (this.moD != null)
    {
      Log.i("GameChatRoom.GameChatCommentFooter", "commentfooter release");
      this.moD.iKg();
      this.moD.destroy();
    }
    if (this.nir != null) {
      this.nir.destroy();
    }
    if (this.Iqy != null)
    {
      this.Iqy.IqP = null;
      this.Iqy.Ykx = null;
      this.Iqy.hide();
    }
    AppMethodBeat.o(276556);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(276491);
    super.onFinishInflate();
    Object localObject = (ViewGroup)inflate(this.lzt, h.f.IhK, this);
    this.Iqu = ((ViewGroup)findViewById(h.e.IfV));
    this.Iqv = ((TextView)findViewById(h.e.IfW));
    this.Iqw = ((ImageView)findViewById(h.e.IfU));
    this.Iqw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276164);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatCommentFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        GameChatCommentFooter.e(GameChatCommentFooter.this).setVisibility(8);
        GameChatCommentFooter.f(GameChatCommentFooter.this).b(false, null, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatCommentFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276164);
      }
    });
    this.nir = ((MMEditText)findViewById(h.e.IfZ));
    this.DcK = ((TextView)findViewById(h.e.IfY));
    this.nit = ((ImageView)findViewById(h.e.IfX));
    this.nis = ((TextView)((ViewGroup)localObject).findViewById(h.e.Iga));
    this.nis.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276160);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatCommentFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i;
        if (GameChatCommentFooter.a(GameChatCommentFooter.this) != null)
        {
          paramAnonymousView = GameChatCommentFooter.g(GameChatCommentFooter.this).getText().toString();
          i = com.tencent.mm.plugin.game.chatroom.g.a.Ieu;
          if ((GameChatCommentFooter.e(GameChatCommentFooter.this).getVisibility() != 0) || (!(GameChatCommentFooter.e(GameChatCommentFooter.this).getTag() instanceof Channel))) {
            break label148;
          }
          i = ((Channel)GameChatCommentFooter.e(GameChatCommentFooter.this).getTag()).channel_id;
        }
        for (;;)
        {
          GameChatCommentFooter.a(GameChatCommentFooter.this).d(paramAnonymousView, GameChatCommentFooter.a(GameChatCommentFooter.this, paramAnonymousView), i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatCommentFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276160);
          return;
          label148:
          if (GameChatCommentFooter.h(GameChatCommentFooter.this) != null) {
            i = GameChatCommentFooter.h(GameChatCommentFooter.this).channel_id;
          }
        }
      }
    });
    this.niw = ((int)StaticLayout.getDesiredWidth(this.nis.getText(), this.nis.getPaint()) + this.nis.getPaddingStart() + this.nis.getPaddingEnd());
    if (this.niw < bd.bs(this.lzt, h.c.Edge_7A)) {
      this.niw = bd.bs(this.lzt, h.c.Edge_7A);
    }
    localObject = new GameChatCommentFooter.6(this, com.tencent.mm.ui.tools.g.a.afII);
    this.nir.setFilters(new InputFilter[] { localObject });
    this.nir.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(276458);
        GameChatCommentFooter.p(GameChatCommentFooter.this);
        paramAnonymousEditable = GameChatCommentFooter.g(GameChatCommentFooter.this).getText().toString();
        GameChatCommentFooter.c(GameChatCommentFooter.this, paramAnonymousEditable);
        if (!Util.isNullOrNil(paramAnonymousEditable)) {}
        for (boolean bool = true;; bool = false)
        {
          if (bool == GameChatCommentFooter.q(GameChatCommentFooter.this))
          {
            AppMethodBeat.o(276458);
            return;
          }
          GameChatCommentFooter.c(GameChatCommentFooter.this, bool);
          paramAnonymousEditable = (LinearLayout.LayoutParams)GameChatCommentFooter.l(GameChatCommentFooter.this).getLayoutParams();
          if (bool)
          {
            paramAnonymousEditable.setMarginStart(com.tencent.mm.cd.a.br(GameChatCommentFooter.this.getContext(), h.c.Edge_1_5_A));
            GameChatCommentFooter.l(GameChatCommentFooter.this).setLayoutParams(paramAnonymousEditable);
            paramAnonymousEditable = new ValueAnimator();
            paramAnonymousEditable.setIntValues(new int[] { 0, GameChatCommentFooter.r(GameChatCommentFooter.this) });
            paramAnonymousEditable.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                AppMethodBeat.i(276300);
                int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
                paramAnonymous2ValueAnimator = GameChatCommentFooter.s(GameChatCommentFooter.this).getLayoutParams();
                paramAnonymous2ValueAnimator.width = i;
                GameChatCommentFooter.s(GameChatCommentFooter.this).setLayoutParams(paramAnonymous2ValueAnimator);
                GameChatCommentFooter.s(GameChatCommentFooter.this).setAlpha(i / GameChatCommentFooter.r(GameChatCommentFooter.this));
                AppMethodBeat.o(276300);
              }
            });
            paramAnonymousEditable.setDuration(150L);
            paramAnonymousEditable.addListener(new Animator.AnimatorListener()
            {
              public final void onAnimationCancel(Animator paramAnonymous2Animator)
              {
                AppMethodBeat.i(276306);
                paramAnonymous2Animator = GameChatCommentFooter.s(GameChatCommentFooter.this).getLayoutParams();
                paramAnonymous2Animator.width = GameChatCommentFooter.r(GameChatCommentFooter.this);
                GameChatCommentFooter.s(GameChatCommentFooter.this).setLayoutParams(paramAnonymous2Animator);
                GameChatCommentFooter.s(GameChatCommentFooter.this).setAlpha(1.0F);
                AppMethodBeat.o(276306);
              }
              
              public final void onAnimationEnd(Animator paramAnonymous2Animator)
              {
                AppMethodBeat.i(276299);
                GameChatCommentFooter.s(GameChatCommentFooter.this).setVisibility(0);
                paramAnonymous2Animator = GameChatCommentFooter.s(GameChatCommentFooter.this).getLayoutParams();
                paramAnonymous2Animator.width = GameChatCommentFooter.r(GameChatCommentFooter.this);
                GameChatCommentFooter.s(GameChatCommentFooter.this).setLayoutParams(paramAnonymous2Animator);
                GameChatCommentFooter.s(GameChatCommentFooter.this).setAlpha(1.0F);
                AppMethodBeat.o(276299);
              }
              
              public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
              
              public final void onAnimationStart(Animator paramAnonymous2Animator)
              {
                AppMethodBeat.i(276294);
                GameChatCommentFooter.s(GameChatCommentFooter.this).setVisibility(0);
                AppMethodBeat.o(276294);
              }
            });
            paramAnonymousEditable.start();
            AppMethodBeat.o(276458);
            return;
          }
          paramAnonymousEditable.setMarginStart(com.tencent.mm.cd.a.br(GameChatCommentFooter.this.getContext(), h.c.Edge_2A));
          GameChatCommentFooter.l(GameChatCommentFooter.this).setLayoutParams(paramAnonymousEditable);
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { GameChatCommentFooter.r(GameChatCommentFooter.this), 0 });
          paramAnonymousEditable.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              AppMethodBeat.i(276295);
              int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
              paramAnonymous2ValueAnimator = GameChatCommentFooter.s(GameChatCommentFooter.this).getLayoutParams();
              paramAnonymous2ValueAnimator.width = i;
              GameChatCommentFooter.s(GameChatCommentFooter.this).setLayoutParams(paramAnonymous2ValueAnimator);
              GameChatCommentFooter.s(GameChatCommentFooter.this).setAlpha(i / GameChatCommentFooter.r(GameChatCommentFooter.this));
              AppMethodBeat.o(276295);
            }
          });
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(276313);
              GameChatCommentFooter.s(GameChatCommentFooter.this).setVisibility(8);
              AppMethodBeat.o(276313);
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(276307);
              GameChatCommentFooter.s(GameChatCommentFooter.this).setVisibility(8);
              AppMethodBeat.o(276307);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(276301);
              GameChatCommentFooter.s(GameChatCommentFooter.this).setVisibility(0);
              AppMethodBeat.o(276301);
            }
          });
          paramAnonymousEditable.start();
          AppMethodBeat.o(276458);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(276440);
        GameChatCommentFooter.b(GameChatCommentFooter.this, String.valueOf(paramAnonymousCharSequence));
        if (GameChatCommentFooter.c(GameChatCommentFooter.this) != null) {
          GameChatCommentFooter.c(GameChatCommentFooter.this).setToSendText(GameChatCommentFooter.g(GameChatCommentFooter.this).getText().toString());
        }
        AppMethodBeat.o(276440);
      }
    });
    localObject = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(276415);
        GameChatCommentFooter.m(GameChatCommentFooter.this);
        GameChatCommentFooter.t(GameChatCommentFooter.this);
        GameChatCommentFooter.l(GameChatCommentFooter.this).setImageDrawable(bb.e(GameChatCommentFooter.this.getResources().getDrawable(h.g.icons_filled_sticker), -1));
        GameChatCommentFooter.b(GameChatCommentFooter.this, 0);
        AppMethodBeat.o(276415);
        return false;
      }
    };
    this.nir.setOnTouchListener((View.OnTouchListener)localObject);
    this.nit.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276170);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("GameChatRoom.GameChatCommentFooter", "state onClick:" + GameChatCommentFooter.i(GameChatCommentFooter.this));
        if (GameChatCommentFooter.i(GameChatCommentFooter.this) == 0)
        {
          GameChatCommentFooter.g(GameChatCommentFooter.this).jEJ();
          GameChatCommentFooter.j(GameChatCommentFooter.this);
          GameChatCommentFooter.b(GameChatCommentFooter.this, 1);
          GameChatCommentFooter.a(GameChatCommentFooter.this, GameChatCommentFooter.k(GameChatCommentFooter.this));
          GameChatCommentFooter.l(GameChatCommentFooter.this).setImageDrawable(bb.e(GameChatCommentFooter.this.getResources().getDrawable(h.g.icons_filled_keyboard), -1));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276170);
          return;
          GameChatCommentFooter.m(GameChatCommentFooter.this);
          GameChatCommentFooter.g(GameChatCommentFooter.this).jEJ();
          GameChatCommentFooter.n(GameChatCommentFooter.this);
          GameChatCommentFooter.b(GameChatCommentFooter.this, 0);
          GameChatCommentFooter.l(GameChatCommentFooter.this).setImageDrawable(bb.e(GameChatCommentFooter.this.getResources().getDrawable(h.g.icons_filled_sticker), -1));
        }
      }
    });
    if (e.Ykf == null)
    {
      this.moD = new d(this.lzt);
      AppMethodBeat.o(276491);
      return;
    }
    this.moD = e.Ykf.fZ(getContext());
    this.moD.setVisibility(8);
    localObject = (LinearLayout)findViewById(h.e.root);
    this.sNb = KeyBoardUtil.getValidPanelHeight(getContext());
    fDy();
    ((LinearLayout)localObject).addView(this.moD, -1, this.IqB);
    this.moD.setShowGame(false);
    this.moD.Jz(false);
    this.moD.Jy(false);
    this.moD.setShowSmiley(true);
    this.moD.setShowSearch(true);
    this.moD.setEntranceScene(ChatFooterPanel.XYA);
    this.moD.setTalkerName(this.IqJ);
    this.moD.setToSendText(this.nir.getText().toString());
    this.moD.onResume();
    this.moD.setOnTextOperationListener(new GameChatCommentFooter.20(this));
    localObject = getContext();
    getRootView();
    this.Iqy = new m((Context)localObject);
    this.Iqy.IqP = this.IqP;
    this.Iqy.Ykw = this.nit;
    localObject = new com.tencent.mm.pluginsdk.ui.chat.j()
    {
      public final void cSg() {}
      
      public final void cSh() {}
      
      public final boolean cSi()
      {
        return false;
      }
      
      public final boolean cSj()
      {
        return false;
      }
      
      public final void o(EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(276200);
        if (GameChatCommentFooter.a(GameChatCommentFooter.this) != null) {
          GameChatCommentFooter.a(GameChatCommentFooter.this).c(paramAnonymousEmojiInfo);
        }
        AppMethodBeat.o(276200);
      }
      
      public final void y(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(276212);
        GameChatCommentFooter.b(GameChatCommentFooter.this, paramAnonymousBoolean);
        AppMethodBeat.o(276212);
      }
    };
    this.moD.setCallback((f)localObject);
    this.Iqy.Ykx = ((com.tencent.mm.pluginsdk.ui.chat.j)localObject);
    AppMethodBeat.o(276491);
  }
  
  public void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(276553);
    super.onInputPanelChange(paramBoolean, paramInt);
    Log.i("GameChatRoom.GameChatCommentFooter", "onInputPanelChange, isKeyboardShow:%b, keyboardHeight:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.nir.Ni(paramBoolean);
    if ((this.sNb != paramInt) && (paramInt != 0))
    {
      this.sNb = paramInt;
      fDy();
      com.tencent.mm.compatible.util.j.H(getContext(), paramInt);
      if (this.moD != null)
      {
        localObject = this.moD.getLayoutParams();
        if (localObject != null) {
          ((ViewGroup.LayoutParams)localObject).height = this.IqB;
        }
      }
    }
    if ((paramBoolean) && (this.moD.getVisibility() == 8))
    {
      localObject = this.moD.getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = this.sNb;
      }
      h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(276155);
          GameChatCommentFooter.c(GameChatCommentFooter.this).setVisibility(0);
          AppMethodBeat.o(276155);
        }
      }, 50L);
    }
    while ((this.moD.getVisibility() == 8) || (this.IqN))
    {
      if ((this.IqC) && (!paramBoolean)) {
        setVisibility(8);
      }
      AppMethodBeat.o(276553);
      return;
    }
    Object localObject = new ValueAnimator();
    if (paramBoolean)
    {
      paramInt = this.IqB;
      label226:
      if (!paramBoolean) {
        break label302;
      }
    }
    label302:
    for (int i = this.sNb;; i = this.IqB)
    {
      ((ValueAnimator)localObject).setIntValues(new int[] { paramInt, i });
      ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(276178);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          Log.d("GameChatRoom.GameChatCommentFooter", "showSmileyAnim value:%d", new Object[] { Integer.valueOf(i) });
          paramAnonymousValueAnimator = (LinearLayout.LayoutParams)GameChatCommentFooter.c(GameChatCommentFooter.this).getLayoutParams();
          paramAnonymousValueAnimator.height = i;
          GameChatCommentFooter.c(GameChatCommentFooter.this).setLayoutParams(paramAnonymousValueAnimator);
          AppMethodBeat.o(276178);
        }
      });
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(276182);
          GameChatCommentFooter.c(GameChatCommentFooter.this).setVisibility(0);
          if (GameChatCommentFooter.a(GameChatCommentFooter.this) != null) {
            GameChatCommentFooter.a(GameChatCommentFooter.this).fDn();
          }
          AppMethodBeat.o(276182);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(276173);
          GameChatCommentFooter.c(GameChatCommentFooter.this).setVisibility(0);
          AppMethodBeat.o(276173);
        }
      });
      ((ValueAnimator)localObject).start();
      break;
      paramInt = this.sNb;
      break label226;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(276554);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Iqz < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.Iqz)
    {
      this.Iqz = paramInt1;
      this.IqA = paramInt4;
      Log.d("GameChatRoom.GameChatCommentFooter", "onLayout, changed:%b, top:%d, bottom:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(276554);
      return;
    }
  }
  
  public void setCanAtAll(boolean paramBoolean)
  {
    this.IqH = paramBoolean;
  }
  
  public void setChannelInfo(Channel paramChannel)
  {
    this.IqM = paramChannel;
  }
  
  public void setFooterActionListener(b paramb)
  {
    this.IqE = paramb;
  }
  
  public void setHostUserName(String paramString)
  {
    AppMethodBeat.i(276511);
    this.IqJ = paramString;
    if (this.moD != null) {
      this.moD.setTalkerName(paramString);
    }
    AppMethodBeat.o(276511);
  }
  
  public void setLastText(String paramString)
  {
    AppMethodBeat.i(276538);
    this.nir.setText(p.b(getContext(), paramString, this.nir.getTextSize()));
    this.nir.setSelection(this.nir.getText().length());
    AppMethodBeat.o(276538);
  }
  
  public void setRobotUserName(String paramString)
  {
    this.IqI = paramString;
  }
  
  public void setShowCustom(boolean paramBoolean)
  {
    AppMethodBeat.i(276542);
    this.IqL = paramBoolean;
    if (this.moD != null)
    {
      this.moD.Jy(paramBoolean);
      this.moD.setShowGame(false);
    }
    AppMethodBeat.o(276542);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(276497);
    jf(paramInt, 1);
    AppMethodBeat.o(276497);
  }
  
  public final void z(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(276522);
    if (paramBoolean) {}
    for (String str = "@" + paramString2 + ' ';; str = paramString2 + ' ')
    {
      List localList = (List)this.IqF.get(paramString1);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      ((List)localObject).add(paramString2);
      this.IqF.put(paramString1, localObject);
      a(str, null);
      AppMethodBeat.o(276522);
      return;
    }
  }
  
  final class a
  {
    boolean IqU;
    Channel IqV;
    boolean hBY = false;
    
    a() {}
    
    final void b(boolean paramBoolean1, Channel paramChannel, boolean paramBoolean2)
    {
      this.hBY = paramBoolean1;
      this.IqV = paramChannel;
      this.IqU = paramBoolean2;
    }
  }
  
  public static abstract interface b
  {
    public abstract void c(t paramt);
    
    public abstract void d(String paramString, List paramList, int paramInt);
    
    public abstract void fDn();
    
    public abstract void wg(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter
 * JD-Core Version:    0.7.0.1
 */