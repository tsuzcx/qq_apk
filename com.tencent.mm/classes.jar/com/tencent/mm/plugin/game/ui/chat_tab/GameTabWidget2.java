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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import org.json.JSONObject;

public class GameTabWidget2
  extends LinearLayout
{
  private static final String xXo;
  private Activity mActivity;
  private a xXp;
  private boolean xXq;
  private boolean xXr;
  boolean xXs;
  private GameTabData2.TabItem xXt;
  private boolean xXu;
  
  static
  {
    AppMethodBeat.i(204275);
    xXo = com.tencent.mm.plugin.game.commlib.util.b.a(b.a.xvI) + "tabnav/";
    AppMethodBeat.o(204275);
  }
  
  public GameTabWidget2(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204264);
    this.xXq = true;
    this.xXr = false;
    this.xXs = true;
    this.xXu = false;
    bh(paramContext);
    AppMethodBeat.o(204264);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204265);
    this.xXq = true;
    this.xXr = false;
    this.xXs = true;
    this.xXu = false;
    bh(paramContext);
    AppMethodBeat.o(204265);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204266);
    this.xXq = true;
    this.xXr = false;
    this.xXs = true;
    this.xXu = false;
    bh(paramContext);
    AppMethodBeat.o(204266);
  }
  
  public static void a(Activity paramActivity, GameTabData2.TabItem paramTabItem, boolean paramBoolean)
  {
    AppMethodBeat.i(204273);
    if ((paramActivity == null) || (paramTabItem == null))
    {
      AppMethodBeat.o(204273);
      return;
    }
    Object localObject1 = paramActivity.getIntent();
    if (localObject1 == null)
    {
      AppMethodBeat.o(204273);
      return;
    }
    Object localObject2 = ((Intent)localObject1).getStringExtra("game_red_dot_tab_key");
    if (Util.nullAsNil(paramTabItem.xHB).equalsIgnoreCase(Util.nullAsNil((String)localObject2)))
    {
      ((Intent)localObject1).putExtra("game_red_dot_tab_key", "");
      localObject2 = ((Intent)localObject1).getStringExtra("game_tab_red_dot_msgid");
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(Util.nullAsNil((String)localObject2)), b.class, null);
    }
    int j = ((Intent)localObject1).getIntExtra("game_report_from_scene", 0);
    int i;
    long l;
    Object localObject3;
    if (!paramBoolean) {
      if (paramTabItem.dLS == 1)
      {
        i = 6;
        localObject2 = com.tencent.mm.game.report.c.hhl;
        int k = paramTabItem.position;
        int m = paramTabItem.xXm;
        localObject2 = paramTabItem.xHB;
        l = j;
        p.h(localObject2, "tabKey");
        localObject3 = com.tencent.mm.game.report.c.a.a(1L, 101L, k, 2L, l);
        ((eq)localObject3).eEm = m;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("red_dot", i);
        localJSONObject.put("tab_key", localObject2);
        ((eq)localObject3).rQ(URLEncoder.encode(localJSONObject.toString()));
        ((eq)localObject3).bfK();
      }
    }
    for (;;)
    {
      if (paramTabItem.dLS != 3) {
        break label384;
      }
      localObject1 = com.tencent.mm.game.report.c.hhl;
      i = paramTabItem.position;
      localObject1 = paramTabItem.xHB;
      l = j;
      p.h(localObject1, "tabKey");
      localObject2 = com.tencent.mm.game.report.c.a.a(1L, 101L, i, 71L, l);
      ((eq)localObject2).eEm = 0L;
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("red_dot", 0);
      ((JSONObject)localObject3).put("tab_key", localObject1);
      ((eq)localObject2).rQ(URLEncoder.encode(((JSONObject)localObject3).toString()));
      ((eq)localObject2).bfK();
      com.tencent.mm.plugin.game.e.c.E(paramActivity, paramTabItem.xXi.jfi, paramTabItem.xXi.xut);
      AppMethodBeat.o(204273);
      return;
      i = 0;
      break;
      ((Intent)localObject1).putExtra("disable_minimize", true);
    }
    label384:
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
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.overridePendingTransition(2130772082, 2130772082);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("from_game_tab", true);
      ((Bundle)localObject1).putString("game_tab_key", paramTabItem.xHB);
      ((Bundle)localObject1).putInt("game_tab_type", paramTabItem.dLS);
      ((Bundle)localObject1).putLong("turn_page_time", System.currentTimeMillis());
      ((Bundle)localObject1).putString("rawUrl", paramTabItem.jumpUrl);
      ((Bundle)localObject1).putBoolean("from_find_more_friend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).setClassName(paramActivity, paramTabItem.xHI);
      ((Intent)localObject2).addFlags(65536);
      ((Intent)localObject2).addFlags(131072);
      try
      {
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramBoolean)
        {
          paramActivity.overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
          AppMethodBeat.o(204273);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        Log.printErrStackTrace("MicroMsg.GameTabWidget2", paramActivity, "className:[%s]", new Object[] { paramTabItem.xHI });
        AppMethodBeat.o(204273);
        return;
      }
      paramActivity.overridePendingTransition(2130772082, 2130772082);
      AppMethodBeat.o(204273);
      return;
    }
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(204271);
    this.mActivity = ((Activity)paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundResource(2131100530);
    setOrientation(0);
    AppMethodBeat.o(204271);
  }
  
  private void setAdapter(a parama)
  {
    AppMethodBeat.i(204272);
    this.xXp = parama;
    parama.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(204247);
        GameTabWidget2.b(GameTabWidget2.this);
        AppMethodBeat.o(204247);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(204246);
        GameTabWidget2.b(GameTabWidget2.this);
        AppMethodBeat.o(204246);
      }
    });
    parama.notifyDataSetChanged();
    AppMethodBeat.o(204272);
  }
  
  public final void a(GameTabData2 paramGameTabData2, String paramString)
  {
    AppMethodBeat.i(204267);
    if (paramGameTabData2 == null)
    {
      AppMethodBeat.o(204267);
      return;
    }
    Object localObject = new a(getContext());
    setAdapter((a)localObject);
    ((a)localObject).a(paramGameTabData2, paramString, this.mActivity.getIntent().getStringExtra("game_red_dot_tab_key"));
    int i = com.tencent.mm.plugin.game.e.c.parseColor(paramGameTabData2.lco);
    int j = com.tencent.mm.plugin.game.e.c.parseColor(paramGameTabData2.xWZ);
    if (ao.isDarkMode()) {
      if (j != 0) {
        setBackgroundColor(j);
      }
    }
    while (this.mActivity.getIntent().getBooleanExtra("game_tab_exposure", true))
    {
      this.mActivity.getIntent().putExtra("game_tab_exposure", false);
      paramString = this.mActivity.getIntent().getStringExtra("game_tab_key");
      j = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      localObject = com.tencent.mm.game.report.c.hhl;
      com.tencent.mm.game.report.c.a.t(paramString, j);
      paramString = paramGameTabData2.xWX.entrySet().iterator();
      i = 0;
      for (;;)
      {
        if (paramString.hasNext())
        {
          localObject = (GameTabData2.TabItem)((Map.Entry)paramString.next()).getValue();
          if (localObject == null) {
            break label285;
          }
          i += 1;
          if (((GameTabData2.TabItem)localObject).xHB.equals(paramGameTabData2.dWA()))
          {
            this.xXt = ((GameTabData2.TabItem)localObject);
            this.xXu = true;
            continue;
            if (i == 0) {
              break;
            }
            setBackgroundColor(i);
            break;
          }
          com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.hhl;
          com.tencent.mm.game.report.c.a.a(i, 0, ((GameTabData2.TabItem)localObject).xHB, 0, j);
        }
      }
    }
    label285:
    for (;;)
    {
      break;
      AppMethodBeat.o(204267);
      return;
    }
  }
  
  public final void aA(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204270);
    if ((this.xXu) && (this.xXt != null))
    {
      this.xXu = false;
      int i = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.hhl;
      com.tencent.mm.game.report.c.a.a(this.xXt.position, paramInt, this.xXt.xHB, 6, i);
    }
    if (this.xXp != null) {
      this.xXp.aA(paramInt, paramBoolean);
    }
    AppMethodBeat.o(204270);
  }
  
  public final void dWE()
  {
    AppMethodBeat.i(204268);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204245);
        if (GameTabWidget2.a(GameTabWidget2.this) != null) {
          GameTabWidget2.a(GameTabWidget2.this).notifyDataSetInvalidated();
        }
        AppMethodBeat.o(204245);
      }
    });
    AppMethodBeat.o(204268);
  }
  
  public final void hP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204269);
    if (this.xXp != null) {
      this.xXp.hQ(paramString1, paramString2);
    }
    AppMethodBeat.o(204269);
  }
  
  public void setPageChanging(boolean paramBoolean)
  {
    this.xXr = paramBoolean;
  }
  
  public void setTabSwitchEnable(boolean paramBoolean)
  {
    this.xXq = paramBoolean;
  }
  
  final class a
    extends BaseAdapter
  {
    private Context mContext;
    Map<String, a> xXA;
    int xXB;
    boolean xXC;
    private GameTabData2 xXx;
    private String xXy;
    private String xXz;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(204252);
      this.xXA = new HashMap();
      this.xXB = 0;
      this.xXC = false;
      this.mContext = paramContext;
      AppMethodBeat.o(204252);
    }
    
    private void a(a parama, GameTabData2.TabItem paramTabItem, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(204260);
      if (!paramTabItem.dWC())
      {
        parama.xXF.setVisibility(8);
        if (Util.nullAsNil(paramTabItem.xHB).equalsIgnoreCase(paramString)) {
          parama.xXF.setVisibility(0);
        }
      }
      if (ao.isDarkMode())
      {
        i = bI(paramTabItem.xXd, paramBoolean);
        j = bI(paramTabItem.xXe, paramBoolean);
        str1 = paramTabItem.xXg;
        String str2 = paramTabItem.xXh;
        paramString = str2;
        if (Util.isNullOrNil(str2)) {
          paramString = str1;
        }
        str2 = paramString;
        paramString = str1;
        if (Util.isNullOrNil(str1))
        {
          paramString = paramTabItem.iconUrl;
          str2 = paramTabItem.xXf;
        }
        if (paramBoolean)
        {
          c(str2, parama.kc);
          parama.hbb.setTextColor(j);
          AppMethodBeat.o(204260);
          return;
        }
        c(paramString, parama.kc);
        parama.hbb.setTextColor(i);
        AppMethodBeat.o(204260);
        return;
      }
      int i = bI(paramTabItem.iyd, paramBoolean);
      int j = bI(paramTabItem.xXc, paramBoolean);
      paramString = paramTabItem.iconUrl;
      String str1 = paramTabItem.xXf;
      paramTabItem = str1;
      if (Util.isNullOrNil(str1)) {
        paramTabItem = paramString;
      }
      if (paramBoolean)
      {
        c(paramTabItem, parama.kc);
        parama.hbb.setTextColor(j);
        AppMethodBeat.o(204260);
        return;
      }
      c(paramString, parama.kc);
      parama.hbb.setTextColor(i);
      AppMethodBeat.o(204260);
    }
    
    private int bI(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(204261);
      int j = com.tencent.mm.plugin.game.e.c.parseColor(paramString);
      int i = j;
      if (j == 0) {
        if (!paramBoolean) {
          break label43;
        }
      }
      label43:
      for (i = GameTabWidget2.this.getResources().getColor(2131100566);; i = GameTabWidget2.this.getResources().getColor(2131100505))
      {
        AppMethodBeat.o(204261);
        return i;
      }
    }
    
    private static void c(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(204259);
      if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
      {
        AppMethodBeat.o(204259);
        return;
      }
      if (!Util.isNullOrNil(paramString))
      {
        Object localObject = GameTabWidget2.xXo + g.getMessageDigest(paramString.getBytes());
        com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
        locala.jbf = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bdv();
        com.tencent.mm.av.a.a.bdb().a(paramString, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
      }
      AppMethodBeat.o(204259);
    }
    
    private void l(TextView paramTextView, int paramInt)
    {
      AppMethodBeat.i(204255);
      if (paramInt >= 100)
      {
        paramTextView.setText("");
        paramTextView.setBackgroundResource(2131689753);
        paramTextView.setTextSize(0, com.tencent.mm.cb.a.aH(GameTabWidget2.this.getContext(), 2131167084));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(204255);
        return;
      }
      paramTextView.setText(String.valueOf(paramInt));
      paramTextView.setBackgroundResource(v.aQ(GameTabWidget2.this.getContext(), paramInt));
      paramTextView.setTextSize(0, com.tencent.mm.cb.a.aH(GameTabWidget2.this.getContext(), 2131167084) * com.tencent.mm.cb.a.ji(GameTabWidget2.this.getContext()));
      paramTextView.setVisibility(0);
      AppMethodBeat.o(204255);
    }
    
    public final void a(GameTabData2 paramGameTabData2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(204253);
      this.xXx = paramGameTabData2;
      this.xXy = paramString1;
      this.xXz = paramString2;
      notifyDataSetChanged();
      AppMethodBeat.o(204253);
    }
    
    public final void aA(int paramInt, final boolean paramBoolean)
    {
      AppMethodBeat.i(204254);
      this.xXB = paramInt;
      this.xXC = paramBoolean;
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        com.tencent.f.h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204250);
            GameTabWidget2.a.this.aA(GameTabWidget2.a.a(GameTabWidget2.a.this), paramBoolean);
            AppMethodBeat.o(204250);
          }
        });
        AppMethodBeat.o(204254);
        return;
      }
      if (this.xXx != null)
      {
        Object localObject = this.xXx.dWA();
        localObject = (a)this.xXA.get(localObject);
        if (localObject != null)
        {
          ((a)localObject).xXG.setTag(Integer.valueOf(paramInt));
          ((a)localObject).xXF.setVisibility(8);
          if (paramInt > 0)
          {
            l(((a)localObject).xXG, paramInt);
            AppMethodBeat.o(204254);
            return;
          }
          ((a)localObject).xXG.setVisibility(4);
          if (paramBoolean) {
            ((a)localObject).xXF.setVisibility(0);
          }
        }
      }
      AppMethodBeat.o(204254);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(204257);
      if (this.xXx == null)
      {
        AppMethodBeat.o(204257);
        return 0;
      }
      int i = this.xXx.avn().size();
      AppMethodBeat.o(204257);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(204258);
      paramView = LayoutInflater.from(this.mContext).inflate(2131494836, paramViewGroup, false);
      paramViewGroup = new a(paramView);
      if (com.tencent.mm.cb.a.jk(GameTabWidget2.this.getContext()))
      {
        paramViewGroup.hbb.setTextSize(0, com.tencent.mm.cb.a.aH(GameTabWidget2.this.getContext(), 2131165429) * com.tencent.mm.cb.a.ji(GameTabWidget2.this.getContext()));
        paramViewGroup.xXG.setTextSize(0, com.tencent.mm.cb.a.aH(GameTabWidget2.this.getContext(), 2131165429) * com.tencent.mm.cb.a.ji(GameTabWidget2.this.getContext()));
      }
      GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.xXx.avn().get(paramInt);
      if (localTabItem != null)
      {
        paramViewGroup.hbb.setText(localTabItem.title);
        a(paramViewGroup, localTabItem, Util.nullAsNil(this.xXy).equalsIgnoreCase(localTabItem.xHB), this.xXz);
        this.xXA.put(localTabItem.xHB, paramViewGroup);
      }
      paramView.setTag(localTabItem);
      AppMethodBeat.o(204258);
      return paramView;
    }
    
    public final void hQ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(204256);
      this.xXz = paramString2;
      paramString2 = this.xXA.entrySet().iterator();
      while (paramString2.hasNext())
      {
        Object localObject = (Map.Entry)paramString2.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (a)((Map.Entry)localObject).getValue();
        GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.xXx.xWX.get(str);
        if ((localObject != null) && (localTabItem != null)) {
          a((a)localObject, localTabItem, Util.nullAsNil(paramString1).equalsIgnoreCase(str), this.xXz);
        }
      }
      AppMethodBeat.o(204256);
    }
    
    public final class a
    {
      TextView hbb;
      ImageView kc;
      ImageView xXF;
      TextView xXG;
      
      public a(View paramView)
      {
        AppMethodBeat.i(204251);
        this.hbb = ((TextView)paramView.findViewById(2131297708));
        this.kc = ((ImageView)paramView.findViewById(2131297705));
        this.xXF = ((ImageView)paramView.findViewById(2131307103));
        this.xXG = ((TextView)paramView.findViewById(2131297707));
        AppMethodBeat.o(204251);
      }
    }
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2
 * JD-Core Version:    0.7.0.1
 */