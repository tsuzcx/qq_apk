package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hl;
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.v;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.s;
import org.json.JSONObject;

public class GameTabWidget2
  extends LinearLayout
{
  private static final String IWm;
  private a IWn;
  private boolean IWo;
  private boolean IWp;
  boolean IWq;
  private GameTabData2.TabItem IWr;
  private boolean IWs;
  private List<View> IWt;
  private Activity mActivity;
  
  static
  {
    AppMethodBeat.i(276777);
    IWm = com.tencent.mm.plugin.game.commlib.e.c.a(com.tencent.mm.plugin.game.commlib.e.c.a.Ito) + "tabnav/";
    AppMethodBeat.o(276777);
  }
  
  public GameTabWidget2(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(276733);
    this.IWo = true;
    this.IWp = false;
    this.IWq = true;
    this.IWs = false;
    this.IWt = new ArrayList();
    ci(paramContext);
    AppMethodBeat.o(276733);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276735);
    this.IWo = true;
    this.IWp = false;
    this.IWq = true;
    this.IWs = false;
    this.IWt = new ArrayList();
    ci(paramContext);
    AppMethodBeat.o(276735);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276739);
    this.IWo = true;
    this.IWp = false;
    this.IWq = true;
    this.IWs = false;
    this.IWt = new ArrayList();
    ci(paramContext);
    AppMethodBeat.o(276739);
  }
  
  public static void a(Activity paramActivity, GameTabData2.TabItem paramTabItem, boolean paramBoolean)
  {
    AppMethodBeat.i(276760);
    if ((paramActivity == null) || (paramTabItem == null))
    {
      AppMethodBeat.o(276760);
      return;
    }
    Object localObject1 = paramActivity.getIntent();
    if (localObject1 == null)
    {
      AppMethodBeat.o(276760);
      return;
    }
    Object localObject2 = ((Intent)localObject1).getStringExtra("game_red_dot_tab_key");
    if (Util.nullAsNil(paramTabItem.IFL).equalsIgnoreCase(Util.nullAsNil((String)localObject2)))
    {
      ((Intent)localObject1).putExtra("game_red_dot_tab_key", "");
      localObject2 = ((Intent)localObject1).getStringExtra("game_tab_red_dot_msgid");
      j.a(MainProcessIPCService.PROCESS_NAME, new IPCString(Util.nullAsNil((String)localObject2)), b.class, null);
    }
    int j = ((Intent)localObject1).getIntExtra("game_report_from_scene", 0);
    int i;
    long l;
    Object localObject3;
    if (!paramBoolean) {
      if (paramTabItem.hJx == 1)
      {
        i = 6;
        localObject2 = com.tencent.mm.game.report.c.mtx;
        int k = paramTabItem.position;
        int m = paramTabItem.hTq;
        localObject2 = paramTabItem.IFL;
        l = j;
        s.u(localObject2, "tabKey");
        localObject3 = com.tencent.mm.game.report.c.a.a(1L, 101L, k, 2L, l);
        ((hl)localObject3).iOD = m;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("red_dot", i);
        localJSONObject.put("tab_key", localObject2);
        ((hl)localObject3).rA(URLEncoder.encode(localJSONObject.toString()));
        ((hl)localObject3).bMH();
        ((Intent)localObject1).putExtra("game_from_detail_back", false);
      }
    }
    for (;;)
    {
      if (paramTabItem.hJx != 3) {
        break label394;
      }
      localObject1 = com.tencent.mm.game.report.c.mtx;
      i = paramTabItem.position;
      localObject1 = paramTabItem.IFL;
      l = j;
      s.u(localObject1, "tabKey");
      localObject2 = com.tencent.mm.game.report.c.a.a(1L, 101L, i, 71L, l);
      ((hl)localObject2).iOD = 0L;
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("red_dot", 0);
      ((JSONObject)localObject3).put("tab_key", localObject1);
      ((hl)localObject2).rA(URLEncoder.encode(((JSONObject)localObject3).toString()));
      ((hl)localObject2).bMH();
      com.tencent.mm.plugin.game.d.c.J(paramActivity, paramTabItem.IWh.oOI, paramTabItem.IWh.IcT);
      AppMethodBeat.o(276760);
      return;
      i = 0;
      break;
      ((Intent)localObject1).putExtra("disable_minimize", true);
    }
    label394:
    localObject1 = ((Intent)localObject1).getExtras();
    if (localObject1 == null) {
      localObject1 = new Bundle();
    }
    for (;;)
    {
      localObject2 = ((Bundle)localObject1).getString("from_source_activity");
      if (!Util.isNullOrNil((String)localObject2))
      {
        Log.i("MicroMsg.GameTabWidget2", "fromSourceActivity: %s", new Object[] { localObject2 });
        localObject3 = new Intent();
        ((Intent)localObject3).addFlags(65536);
        ((Intent)localObject3).addFlags(131072);
        ((Intent)localObject3).setClassName(paramActivity, (String)localObject2);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject3);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        i = h.a.HSF;
        paramActivity.overridePendingTransition(i, i);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("from_game_tab", true);
      ((Bundle)localObject1).putString("game_tab_key", paramTabItem.IFL);
      ((Bundle)localObject1).putInt("game_tab_type", paramTabItem.hJx);
      ((Bundle)localObject1).putLong("turn_page_time", System.currentTimeMillis());
      ((Bundle)localObject1).putString("rawUrl", paramTabItem.jumpUrl);
      ((Bundle)localObject1).putBoolean("from_find_more_friend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).setClassName(paramActivity, paramTabItem.IFS);
      ((Intent)localObject2).addFlags(65536);
      ((Intent)localObject2).addFlags(131072);
      try
      {
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramBoolean)
        {
          paramActivity.overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
          AppMethodBeat.o(276760);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        Log.printErrStackTrace("MicroMsg.GameTabWidget2", paramActivity, "className:[%s]", new Object[] { paramTabItem.IFS });
        AppMethodBeat.o(276760);
        return;
      }
      i = h.a.HSF;
      paramActivity.overridePendingTransition(i, i);
      AppMethodBeat.o(276760);
      return;
    }
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(276744);
    this.mActivity = ((Activity)paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundResource(h.b.HSO);
    setOrientation(0);
    AppMethodBeat.o(276744);
  }
  
  private String getTopChatRoomName()
  {
    AppMethodBeat.i(276749);
    String str = Util.nullAsNil(this.mActivity.getIntent().getStringExtra("game_msg_top_chatroom_name"));
    AppMethodBeat.o(276749);
    return str;
  }
  
  private void setAdapter(a parama)
  {
    AppMethodBeat.i(276746);
    this.IWn = parama;
    parama.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(276685);
        GameTabWidget2.c(GameTabWidget2.this);
        AppMethodBeat.o(276685);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(276678);
        GameTabWidget2.c(GameTabWidget2.this);
        AppMethodBeat.o(276678);
      }
    });
    parama.notifyDataSetChanged();
    AppMethodBeat.o(276746);
  }
  
  public final void a(GameTabData2 paramGameTabData2, String paramString)
  {
    AppMethodBeat.i(276780);
    if (paramGameTabData2 == null)
    {
      AppMethodBeat.o(276780);
      return;
    }
    if (paramGameTabData2.fHJ()) {
      j.a(MainProcessIPCService.PROCESS_NAME, new IPCString(getTopChatRoomName()), c.class, null);
    }
    Object localObject = new a(getContext());
    setAdapter((a)localObject);
    ((a)localObject).a(paramGameTabData2, paramString, this.mActivity.getIntent().getStringExtra("game_red_dot_tab_key"));
    int i = com.tencent.mm.plugin.game.d.c.aHm(paramGameTabData2.qWk);
    int j = com.tencent.mm.plugin.game.d.c.aHm(paramGameTabData2.IVY);
    if (aw.isDarkMode()) {
      if (j != 0) {
        setBackgroundColor(j);
      }
    }
    while (this.mActivity.getIntent().getBooleanExtra("game_tab_exposure", true))
    {
      this.mActivity.getIntent().putExtra("game_tab_exposure", false);
      paramString = this.mActivity.getIntent().getStringExtra("game_tab_key");
      j = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      localObject = com.tencent.mm.game.report.c.mtx;
      com.tencent.mm.game.report.c.a.r(paramString, j);
      paramString = paramGameTabData2.IVW.entrySet().iterator();
      i = 0;
      for (;;)
      {
        if (paramString.hasNext())
        {
          localObject = (GameTabData2.TabItem)((Map.Entry)paramString.next()).getValue();
          if (localObject == null) {
            break label313;
          }
          i += 1;
          if (((GameTabData2.TabItem)localObject).IFL.equals(paramGameTabData2.fHI()))
          {
            this.IWr = ((GameTabData2.TabItem)localObject);
            this.IWs = true;
            continue;
            if (i == 0) {
              break;
            }
            setBackgroundColor(i);
            break;
          }
          com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.mtx;
          com.tencent.mm.game.report.c.a.a(i, 0, ((GameTabData2.TabItem)localObject).IFL, 0, j);
        }
      }
    }
    label313:
    for (;;)
    {
      break;
      AppMethodBeat.o(276780);
      return;
    }
  }
  
  public final void be(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(276791);
    if ((this.IWs) && (this.IWr != null))
    {
      this.IWs = false;
      int i = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.mtx;
      com.tencent.mm.game.report.c.a.a(this.IWr.position, paramInt, this.IWr.IFL, 6, i);
    }
    if (this.IWn != null) {
      this.IWn.be(paramInt, paramBoolean);
    }
    AppMethodBeat.o(276791);
  }
  
  public final void fHN()
  {
    AppMethodBeat.i(276783);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276674);
        if (GameTabWidget2.a(GameTabWidget2.this) != null) {
          GameTabWidget2.a(GameTabWidget2.this).notifyDataSetInvalidated();
        }
        AppMethodBeat.o(276674);
      }
    });
    AppMethodBeat.o(276783);
  }
  
  public final void jf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(276785);
    if (this.IWn != null) {
      this.IWn.jg(paramString1, paramString2);
    }
    AppMethodBeat.o(276785);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(276781);
    super.onAttachedToWindow();
    if ((this.IWr != null) && (this.IWr.Aeu)) {
      j.a(MainProcessIPCService.PROCESS_NAME, new IPCString(getTopChatRoomName()), c.class, null);
    }
    AppMethodBeat.o(276781);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(276782);
    super.onDetachedFromWindow();
    j.a(MainProcessIPCService.PROCESS_NAME, null, d.class, null);
    AppMethodBeat.o(276782);
  }
  
  public void setPageChanging(boolean paramBoolean)
  {
    this.IWp = paramBoolean;
  }
  
  public void setTabSwitchEnable(boolean paramBoolean)
  {
    this.IWo = paramBoolean;
  }
  
  class a
    extends BaseAdapter
  {
    int IWA;
    boolean IWB;
    private GameTabData2 IWw;
    private String IWx;
    private String IWy;
    Map<String, a> IWz;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(276590);
      this.IWz = new HashMap();
      this.IWA = 0;
      this.IWB = false;
      this.mContext = paramContext;
      AppMethodBeat.o(276590);
    }
    
    private void a(a parama, GameTabData2.TabItem paramTabItem, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(276609);
      if (!paramTabItem.fHL())
      {
        parama.IWE.setVisibility(8);
        if (Util.nullAsNil(paramTabItem.IFL).equalsIgnoreCase(paramString)) {
          parama.IWE.setVisibility(0);
        }
      }
      if (aw.isDarkMode())
      {
        i = ci(paramTabItem.IWc, paramBoolean);
        j = ci(paramTabItem.IWd, paramBoolean);
        str1 = paramTabItem.IWf;
        String str2 = paramTabItem.IWg;
        paramString = str2;
        if (Util.isNullOrNil(str2)) {
          paramString = str1;
        }
        str2 = paramString;
        paramString = str1;
        if (Util.isNullOrNil(str1))
        {
          paramString = paramTabItem.iconUrl;
          str2 = paramTabItem.IWe;
        }
        if (paramBoolean)
        {
          d(str2, parama.dpM);
          parama.mll.setTextColor(j);
          AppMethodBeat.o(276609);
          return;
        }
        d(paramString, parama.dpM);
        parama.mll.setTextColor(i);
        AppMethodBeat.o(276609);
        return;
      }
      int i = ci(paramTabItem.nSx, paramBoolean);
      int j = ci(paramTabItem.IWb, paramBoolean);
      paramString = paramTabItem.iconUrl;
      String str1 = paramTabItem.IWe;
      paramTabItem = str1;
      if (Util.isNullOrNil(str1)) {
        paramTabItem = paramString;
      }
      if (paramBoolean)
      {
        d(paramTabItem, parama.dpM);
        parama.mll.setTextColor(j);
        AppMethodBeat.o(276609);
        return;
      }
      d(paramString, parama.dpM);
      parama.mll.setTextColor(i);
      AppMethodBeat.o(276609);
    }
    
    private int ci(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(276616);
      int j = com.tencent.mm.plugin.game.d.c.aHm(paramString);
      int i = j;
      if (j == 0) {
        if (!paramBoolean) {
          break label44;
        }
      }
      label44:
      for (i = GameTabWidget2.this.getResources().getColor(h.b.green_text_color);; i = GameTabWidget2.this.getResources().getColor(h.b.HSH))
      {
        AppMethodBeat.o(276616);
        return i;
      }
    }
    
    private static void d(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(276600);
      if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
      {
        AppMethodBeat.o(276600);
        return;
      }
      if (!Util.isNullOrNil(paramString))
      {
        Object localObject = GameTabWidget2.IWm + g.getMessageDigest(paramString.getBytes());
        com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
        locala.oKp = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bKx();
        com.tencent.mm.modelimage.loader.a.bKl().a(paramString, paramImageView, (com.tencent.mm.modelimage.loader.a.c)localObject);
      }
      AppMethodBeat.o(276600);
    }
    
    private void n(TextView paramTextView, int paramInt)
    {
      AppMethodBeat.i(276596);
      if (paramInt >= 100)
      {
        paramTextView.setText("");
        paramTextView.setBackgroundResource(h.h.badge_count_more);
        paramTextView.setTextSize(0, com.tencent.mm.cd.a.bs(GameTabWidget2.this.getContext(), h.c.unReadCountTextSize));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(276596);
        return;
      }
      paramTextView.setText(String.valueOf(paramInt));
      paramTextView.setBackgroundResource(v.bC(GameTabWidget2.this.getContext(), paramInt));
      paramTextView.setTextSize(0, com.tencent.mm.cd.a.bs(GameTabWidget2.this.getContext(), h.c.unReadCountTextSize) * com.tencent.mm.cd.a.jO(GameTabWidget2.this.getContext()));
      paramTextView.setVisibility(0);
      AppMethodBeat.o(276596);
    }
    
    public final void a(GameTabData2 paramGameTabData2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(276626);
      this.IWw = paramGameTabData2;
      this.IWx = paramString1;
      this.IWy = paramString2;
      notifyDataSetChanged();
      AppMethodBeat.o(276626);
    }
    
    public final void be(int paramInt, final boolean paramBoolean)
    {
      AppMethodBeat.i(276637);
      this.IWA = paramInt;
      this.IWB = paramBoolean;
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276598);
            GameTabWidget2.a.this.be(GameTabWidget2.a.a(GameTabWidget2.a.this), paramBoolean);
            AppMethodBeat.o(276598);
          }
        });
        AppMethodBeat.o(276637);
        return;
      }
      if (this.IWw != null)
      {
        Object localObject = this.IWw.fHI();
        localObject = (a)this.IWz.get(localObject);
        if (localObject != null)
        {
          ((a)localObject).IWF.setTag(Integer.valueOf(paramInt));
          ((a)localObject).IWE.setVisibility(8);
          if (paramInt > 0)
          {
            n(((a)localObject).IWF, paramInt);
            AppMethodBeat.o(276637);
            return;
          }
          ((a)localObject).IWF.setVisibility(4);
          if (paramBoolean) {
            ((a)localObject).IWE.setVisibility(0);
          }
        }
      }
      AppMethodBeat.o(276637);
    }
    
    public int getCount()
    {
      AppMethodBeat.i(276650);
      if (this.IWw == null)
      {
        AppMethodBeat.o(276650);
        return 0;
      }
      int i = this.IWw.aVf().size();
      AppMethodBeat.o(276650);
      return i;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(276661);
      paramView = LayoutInflater.from(this.mContext).inflate(h.f.HYQ, paramViewGroup, false);
      paramViewGroup = new a(paramView);
      if (com.tencent.mm.cd.a.mp(GameTabWidget2.this.getContext()))
      {
        paramViewGroup.mll.setTextSize(0, com.tencent.mm.cd.a.bs(GameTabWidget2.this.getContext(), h.c.HSW) * com.tencent.mm.cd.a.jO(GameTabWidget2.this.getContext()));
        paramViewGroup.IWF.setTextSize(0, com.tencent.mm.cd.a.bs(GameTabWidget2.this.getContext(), h.c.HSW) * com.tencent.mm.cd.a.jO(GameTabWidget2.this.getContext()));
      }
      GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.IWw.aVf().get(paramInt);
      if (localTabItem != null)
      {
        paramViewGroup.mll.setText(localTabItem.title);
        a(paramViewGroup, localTabItem, Util.nullAsNil(this.IWx).equalsIgnoreCase(localTabItem.IFL), this.IWy);
        this.IWz.put(localTabItem.IFL, paramViewGroup);
      }
      paramView.setTag(localTabItem);
      AppMethodBeat.o(276661);
      return paramView;
    }
    
    public final void jg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(276645);
      this.IWy = paramString2;
      paramString2 = this.IWz.entrySet().iterator();
      while (paramString2.hasNext())
      {
        Object localObject = (Map.Entry)paramString2.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (a)((Map.Entry)localObject).getValue();
        GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.IWw.IVW.get(str);
        if ((localObject != null) && (localTabItem != null)) {
          a((a)localObject, localTabItem, Util.nullAsNil(paramString1).equalsIgnoreCase(str), this.IWy);
        }
      }
      AppMethodBeat.o(276645);
    }
    
    public final class a
    {
      ImageView IWE;
      TextView IWF;
      ImageView dpM;
      TextView mll;
      
      public a(View paramView)
      {
        AppMethodBeat.i(276591);
        this.mll = ((TextView)paramView.findViewById(h.e.HTD));
        this.dpM = ((ImageView)paramView.findViewById(h.e.HTB));
        this.IWE = ((ImageView)paramView.findViewById(h.e.HXB));
        this.IWF = ((TextView)paramView.findViewById(h.e.HTC));
        AppMethodBeat.o(276591);
      }
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class b
    implements d<IPCString, IPCVoid>
  {}
  
  @com.tencent.mm.ipcinvoker.c.a
  static class c
    implements d<IPCString, IPCVoid>
  {}
  
  @com.tencent.mm.ipcinvoker.c.a
  static class d
    implements d<IPCVoid, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2
 * JD-Core Version:    0.7.0.1
 */