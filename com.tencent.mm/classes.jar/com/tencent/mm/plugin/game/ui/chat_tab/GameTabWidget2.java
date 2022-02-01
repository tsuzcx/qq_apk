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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.f.b.a.fq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.w;
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
  private static final String DbT;
  private a DbU;
  private boolean DbV;
  private boolean DbW;
  boolean DbX;
  private GameTabData2.TabItem DbY;
  private boolean DbZ;
  private Activity mActivity;
  
  static
  {
    AppMethodBeat.i(199154);
    DbT = com.tencent.mm.plugin.game.commlib.e.c.a(com.tencent.mm.plugin.game.commlib.e.c.a.Czy) + "tabnav/";
    AppMethodBeat.o(199154);
  }
  
  public GameTabWidget2(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199109);
    this.DbV = true;
    this.DbW = false;
    this.DbX = true;
    this.DbZ = false;
    bv(paramContext);
    AppMethodBeat.o(199109);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199111);
    this.DbV = true;
    this.DbW = false;
    this.DbX = true;
    this.DbZ = false;
    bv(paramContext);
    AppMethodBeat.o(199111);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199114);
    this.DbV = true;
    this.DbW = false;
    this.DbX = true;
    this.DbZ = false;
    bv(paramContext);
    AppMethodBeat.o(199114);
  }
  
  public static void a(Activity paramActivity, GameTabData2.TabItem paramTabItem, boolean paramBoolean)
  {
    AppMethodBeat.i(199144);
    if ((paramActivity == null) || (paramTabItem == null))
    {
      AppMethodBeat.o(199144);
      return;
    }
    Object localObject1 = paramActivity.getIntent();
    if (localObject1 == null)
    {
      AppMethodBeat.o(199144);
      return;
    }
    Object localObject2 = ((Intent)localObject1).getStringExtra("game_red_dot_tab_key");
    if (Util.nullAsNil(paramTabItem.CLE).equalsIgnoreCase(Util.nullAsNil((String)localObject2)))
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
      if (paramTabItem.fEH == 1)
      {
        i = 6;
        localObject2 = com.tencent.mm.game.report.c.jTf;
        int k = paramTabItem.position;
        int m = paramTabItem.DbR;
        localObject2 = paramTabItem.CLE;
        l = j;
        p.k(localObject2, "tabKey");
        localObject3 = com.tencent.mm.game.report.c.a.a(1L, 101L, k, 2L, l);
        ((fq)localObject3).gBD = m;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("red_dot", i);
        localJSONObject.put("tab_key", localObject2);
        ((fq)localObject3).ve(URLEncoder.encode(localJSONObject.toString()));
        ((fq)localObject3).bpa();
        ((Intent)localObject1).putExtra("game_from_detail_back", false);
      }
    }
    for (;;)
    {
      if (paramTabItem.fEH != 3) {
        break label394;
      }
      localObject1 = com.tencent.mm.game.report.c.jTf;
      i = paramTabItem.position;
      localObject1 = paramTabItem.CLE;
      l = j;
      p.k(localObject1, "tabKey");
      localObject2 = com.tencent.mm.game.report.c.a.a(1L, 101L, i, 71L, l);
      ((fq)localObject2).gBD = 0L;
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("red_dot", 0);
      ((JSONObject)localObject3).put("tab_key", localObject1);
      ((fq)localObject2).ve(URLEncoder.encode(((JSONObject)localObject3).toString()));
      ((fq)localObject2).bpa();
      com.tencent.mm.plugin.game.d.c.J(paramActivity, paramTabItem.DbN.lVG, paramTabItem.DbN.CqK);
      AppMethodBeat.o(199144);
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
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject3);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        i = g.a.Cgw;
        paramActivity.overridePendingTransition(i, i);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("from_game_tab", true);
      ((Bundle)localObject1).putString("game_tab_key", paramTabItem.CLE);
      ((Bundle)localObject1).putInt("game_tab_type", paramTabItem.fEH);
      ((Bundle)localObject1).putLong("turn_page_time", System.currentTimeMillis());
      ((Bundle)localObject1).putString("rawUrl", paramTabItem.jumpUrl);
      ((Bundle)localObject1).putBoolean("from_find_more_friend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).setClassName(paramActivity, paramTabItem.CLL);
      ((Intent)localObject2).addFlags(65536);
      ((Intent)localObject2).addFlags(131072);
      try
      {
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramBoolean)
        {
          paramActivity.overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
          AppMethodBeat.o(199144);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        Log.printErrStackTrace("MicroMsg.GameTabWidget2", paramActivity, "className:[%s]", new Object[] { paramTabItem.CLL });
        AppMethodBeat.o(199144);
        return;
      }
      i = g.a.Cgw;
      paramActivity.overridePendingTransition(i, i);
      AppMethodBeat.o(199144);
      return;
    }
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(199132);
    this.mActivity = ((Activity)paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundResource(g.b.CgF);
    setOrientation(0);
    AppMethodBeat.o(199132);
  }
  
  private void setAdapter(a parama)
  {
    AppMethodBeat.i(199133);
    this.DbU = parama;
    parama.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(202661);
        GameTabWidget2.b(GameTabWidget2.this);
        AppMethodBeat.o(202661);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(202660);
        GameTabWidget2.b(GameTabWidget2.this);
        AppMethodBeat.o(202660);
      }
    });
    parama.notifyDataSetChanged();
    AppMethodBeat.o(199133);
  }
  
  public final void a(GameTabData2 paramGameTabData2, String paramString)
  {
    AppMethodBeat.i(199123);
    if (paramGameTabData2 == null)
    {
      AppMethodBeat.o(199123);
      return;
    }
    Object localObject = new a(getContext());
    setAdapter((a)localObject);
    ((a)localObject).a(paramGameTabData2, paramString, this.mActivity.getIntent().getStringExtra("game_red_dot_tab_key"));
    int i = com.tencent.mm.plugin.game.d.c.aIQ(paramGameTabData2.nWx);
    int j = com.tencent.mm.plugin.game.d.c.aIQ(paramGameTabData2.DbE);
    if (ar.isDarkMode()) {
      if (j != 0) {
        setBackgroundColor(j);
      }
    }
    while (this.mActivity.getIntent().getBooleanExtra("game_tab_exposure", true))
    {
      this.mActivity.getIntent().putExtra("game_tab_exposure", false);
      paramString = this.mActivity.getIntent().getStringExtra("game_tab_key");
      j = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      localObject = com.tencent.mm.game.report.c.jTf;
      com.tencent.mm.game.report.c.a.q(paramString, j);
      paramString = paramGameTabData2.DbC.entrySet().iterator();
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
          if (((GameTabData2.TabItem)localObject).CLE.equals(paramGameTabData2.ezI()))
          {
            this.DbY = ((GameTabData2.TabItem)localObject);
            this.DbZ = true;
            continue;
            if (i == 0) {
              break;
            }
            setBackgroundColor(i);
            break;
          }
          com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.jTf;
          com.tencent.mm.game.report.c.a.a(i, 0, ((GameTabData2.TabItem)localObject).CLE, 0, j);
        }
      }
    }
    label285:
    for (;;)
    {
      break;
      AppMethodBeat.o(199123);
      return;
    }
  }
  
  public final void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(199130);
    if ((this.DbZ) && (this.DbY != null))
    {
      this.DbZ = false;
      int i = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.jTf;
      com.tencent.mm.game.report.c.a.a(this.DbY.position, paramInt, this.DbY.CLE, 6, i);
    }
    if (this.DbU != null) {
      this.DbU.aE(paramInt, paramBoolean);
    }
    AppMethodBeat.o(199130);
  }
  
  public final void ezM()
  {
    AppMethodBeat.i(199126);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202303);
        if (GameTabWidget2.a(GameTabWidget2.this) != null) {
          GameTabWidget2.a(GameTabWidget2.this).notifyDataSetInvalidated();
        }
        AppMethodBeat.o(202303);
      }
    });
    AppMethodBeat.o(199126);
  }
  
  public final void hY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199129);
    if (this.DbU != null) {
      this.DbU.hZ(paramString1, paramString2);
    }
    AppMethodBeat.o(199129);
  }
  
  public void setPageChanging(boolean paramBoolean)
  {
    this.DbW = paramBoolean;
  }
  
  public void setTabSwitchEnable(boolean paramBoolean)
  {
    this.DbV = paramBoolean;
  }
  
  class a
    extends BaseAdapter
  {
    private GameTabData2 Dcc;
    private String Dcd;
    private String Dce;
    Map<String, a> Dcf;
    int Dcg;
    boolean Dch;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(192041);
      this.Dcf = new HashMap();
      this.Dcg = 0;
      this.Dch = false;
      this.mContext = paramContext;
      AppMethodBeat.o(192041);
    }
    
    private void a(a parama, GameTabData2.TabItem paramTabItem, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(192097);
      if (!paramTabItem.ezK())
      {
        parama.Dck.setVisibility(8);
        if (Util.nullAsNil(paramTabItem.CLE).equalsIgnoreCase(paramString)) {
          parama.Dck.setVisibility(0);
        }
      }
      if (ar.isDarkMode())
      {
        i = bN(paramTabItem.DbI, paramBoolean);
        j = bN(paramTabItem.DbJ, paramBoolean);
        str1 = paramTabItem.DbL;
        String str2 = paramTabItem.DbM;
        paramString = str2;
        if (Util.isNullOrNil(str2)) {
          paramString = str1;
        }
        str2 = paramString;
        paramString = str1;
        if (Util.isNullOrNil(str1))
        {
          paramString = paramTabItem.iconUrl;
          str2 = paramTabItem.DbK;
        }
        if (paramBoolean)
        {
          c(str2, parama.bwJ);
          parama.jMg.setTextColor(j);
          AppMethodBeat.o(192097);
          return;
        }
        c(paramString, parama.bwJ);
        parama.jMg.setTextColor(i);
        AppMethodBeat.o(192097);
        return;
      }
      int i = bN(paramTabItem.lnt, paramBoolean);
      int j = bN(paramTabItem.DbH, paramBoolean);
      paramString = paramTabItem.iconUrl;
      String str1 = paramTabItem.DbK;
      paramTabItem = str1;
      if (Util.isNullOrNil(str1)) {
        paramTabItem = paramString;
      }
      if (paramBoolean)
      {
        c(paramTabItem, parama.bwJ);
        parama.jMg.setTextColor(j);
        AppMethodBeat.o(192097);
        return;
      }
      c(paramString, parama.bwJ);
      parama.jMg.setTextColor(i);
      AppMethodBeat.o(192097);
    }
    
    private int bN(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(192103);
      int j = com.tencent.mm.plugin.game.d.c.aIQ(paramString);
      int i = j;
      if (j == 0) {
        if (!paramBoolean) {
          break label44;
        }
      }
      label44:
      for (i = GameTabWidget2.this.getResources().getColor(g.b.green_text_color);; i = GameTabWidget2.this.getResources().getColor(g.b.Cgy))
      {
        AppMethodBeat.o(192103);
        return i;
      }
    }
    
    private static void c(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(192086);
      if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
      {
        AppMethodBeat.o(192086);
        return;
      }
      if (!Util.isNullOrNil(paramString))
      {
        Object localObject = GameTabWidget2.DbT + g.getMessageDigest(paramString.getBytes());
        com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
        locala.lRD = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bmL();
        com.tencent.mm.ay.a.a.bms().a(paramString, paramImageView, (com.tencent.mm.ay.a.a.c)localObject);
      }
      AppMethodBeat.o(192086);
    }
    
    private void l(TextView paramTextView, int paramInt)
    {
      AppMethodBeat.i(192063);
      if (paramInt >= 100)
      {
        paramTextView.setText("");
        paramTextView.setBackgroundResource(g.h.badge_count_more);
        paramTextView.setTextSize(0, com.tencent.mm.ci.a.aZ(GameTabWidget2.this.getContext(), g.c.unReadCountTextSize));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(192063);
        return;
      }
      paramTextView.setText(String.valueOf(paramInt));
      paramTextView.setBackgroundResource(w.bj(GameTabWidget2.this.getContext(), paramInt));
      paramTextView.setTextSize(0, com.tencent.mm.ci.a.aZ(GameTabWidget2.this.getContext(), g.c.unReadCountTextSize) * com.tencent.mm.ci.a.km(GameTabWidget2.this.getContext()));
      paramTextView.setVisibility(0);
      AppMethodBeat.o(192063);
    }
    
    public final void a(GameTabData2 paramGameTabData2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(192045);
      this.Dcc = paramGameTabData2;
      this.Dcd = paramString1;
      this.Dce = paramString2;
      notifyDataSetChanged();
      AppMethodBeat.o(192045);
    }
    
    public final void aE(int paramInt, final boolean paramBoolean)
    {
      AppMethodBeat.i(192056);
      this.Dcg = paramInt;
      this.Dch = paramBoolean;
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191389);
            GameTabWidget2.a.this.aE(GameTabWidget2.a.a(GameTabWidget2.a.this), paramBoolean);
            AppMethodBeat.o(191389);
          }
        });
        AppMethodBeat.o(192056);
        return;
      }
      if (this.Dcc != null)
      {
        Object localObject = this.Dcc.ezI();
        localObject = (a)this.Dcf.get(localObject);
        if (localObject != null)
        {
          ((a)localObject).Dcl.setTag(Integer.valueOf(paramInt));
          ((a)localObject).Dck.setVisibility(8);
          if (paramInt > 0)
          {
            l(((a)localObject).Dcl, paramInt);
            AppMethodBeat.o(192056);
            return;
          }
          ((a)localObject).Dcl.setVisibility(4);
          if (paramBoolean) {
            ((a)localObject).Dck.setVisibility(0);
          }
        }
      }
      AppMethodBeat.o(192056);
    }
    
    public int getCount()
    {
      AppMethodBeat.i(192072);
      if (this.Dcc == null)
      {
        AppMethodBeat.o(192072);
        return 0;
      }
      int i = this.Dcc.aCj().size();
      AppMethodBeat.o(192072);
      return i;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(192079);
      paramView = LayoutInflater.from(this.mContext).inflate(g.f.CmI, paramViewGroup, false);
      paramViewGroup = new a(paramView);
      if (com.tencent.mm.ci.a.ko(GameTabWidget2.this.getContext()))
      {
        paramViewGroup.jMg.setTextSize(0, com.tencent.mm.ci.a.aZ(GameTabWidget2.this.getContext(), g.c.CgN) * com.tencent.mm.ci.a.km(GameTabWidget2.this.getContext()));
        paramViewGroup.Dcl.setTextSize(0, com.tencent.mm.ci.a.aZ(GameTabWidget2.this.getContext(), g.c.CgN) * com.tencent.mm.ci.a.km(GameTabWidget2.this.getContext()));
      }
      GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.Dcc.aCj().get(paramInt);
      if (localTabItem != null)
      {
        paramViewGroup.jMg.setText(localTabItem.title);
        a(paramViewGroup, localTabItem, Util.nullAsNil(this.Dcd).equalsIgnoreCase(localTabItem.CLE), this.Dce);
        this.Dcf.put(localTabItem.CLE, paramViewGroup);
      }
      paramView.setTag(localTabItem);
      AppMethodBeat.o(192079);
      return paramView;
    }
    
    public final void hZ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(192067);
      this.Dce = paramString2;
      paramString2 = this.Dcf.entrySet().iterator();
      while (paramString2.hasNext())
      {
        Object localObject = (Map.Entry)paramString2.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (a)((Map.Entry)localObject).getValue();
        GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.Dcc.DbC.get(str);
        if ((localObject != null) && (localTabItem != null)) {
          a((a)localObject, localTabItem, Util.nullAsNil(paramString1).equalsIgnoreCase(str), this.Dce);
        }
      }
      AppMethodBeat.o(192067);
    }
    
    public final class a
    {
      ImageView Dck;
      TextView Dcl;
      ImageView bwJ;
      TextView jMg;
      
      public a(View paramView)
      {
        AppMethodBeat.i(208395);
        this.jMg = ((TextView)paramView.findViewById(g.e.Chu));
        this.bwJ = ((ImageView)paramView.findViewById(g.e.Chs));
        this.Dck = ((ImageView)paramView.findViewById(g.e.Clt));
        this.Dcl = ((TextView)paramView.findViewById(g.e.Cht));
        AppMethodBeat.o(208395);
      }
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class b
    implements d<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2
 * JD-Core Version:    0.7.0.1
 */