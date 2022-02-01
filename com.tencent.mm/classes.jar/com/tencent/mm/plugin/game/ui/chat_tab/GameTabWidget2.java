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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.tools.u;
import d.g.b.p;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class GameTabWidget2
  extends LinearLayout
{
  private static final String uFp;
  boolean DRr;
  private Activity mActivity;
  private a uFq;
  private boolean uFr;
  private boolean uFs;
  private GameTabData2.TabItem uFt;
  private boolean uFu;
  
  static
  {
    AppMethodBeat.i(195750);
    uFp = com.tencent.mm.plugin.game.commlib.util.b.a(b.a.udW) + "tabnav/";
    AppMethodBeat.o(195750);
  }
  
  public GameTabWidget2(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195739);
    this.uFr = true;
    this.uFs = false;
    this.DRr = true;
    this.uFu = false;
    aN(paramContext);
    AppMethodBeat.o(195739);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195740);
    this.uFr = true;
    this.uFs = false;
    this.DRr = true;
    this.uFu = false;
    aN(paramContext);
    AppMethodBeat.o(195740);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195741);
    this.uFr = true;
    this.uFs = false;
    this.DRr = true;
    this.uFu = false;
    aN(paramContext);
    AppMethodBeat.o(195741);
  }
  
  public static void a(Activity paramActivity, GameTabData2.TabItem paramTabItem, boolean paramBoolean)
  {
    AppMethodBeat.i(195748);
    if ((paramActivity == null) || (paramTabItem == null))
    {
      AppMethodBeat.o(195748);
      return;
    }
    Object localObject1 = paramActivity.getIntent();
    if (localObject1 == null)
    {
      AppMethodBeat.o(195748);
      return;
    }
    Object localObject2 = ((Intent)localObject1).getStringExtra("game_red_dot_tab_key");
    if (bu.nullAsNil(paramTabItem.upi).equalsIgnoreCase(bu.nullAsNil((String)localObject2)))
    {
      ((Intent)localObject1).putExtra("game_red_dot_tab_key", "");
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", new IPCString(bu.nullAsNil(((Intent)localObject1).getStringExtra("game_tab_red_dot_msgid"))), GameTabWidget2.b.class, null);
    }
    int j = ((Intent)localObject1).getIntExtra("game_report_from_scene", 0);
    int i;
    long l;
    Object localObject3;
    if (!paramBoolean) {
      if (paramTabItem.dvm == 1)
      {
        i = 6;
        localObject2 = com.tencent.mm.game.report.c.guw;
        int k = paramTabItem.position;
        int m = paramTabItem.uFn;
        localObject2 = paramTabItem.upi;
        l = j;
        p.h(localObject2, "tabKey");
        localObject3 = com.tencent.mm.game.report.c.a.a(1L, 101L, k, 2L, l);
        ((cf)localObject3).edK = m;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("red_dot", i);
        localJSONObject.put("tab_key", localObject2);
        ((cf)localObject3).lZ(URLEncoder.encode(localJSONObject.toString()));
        ((cf)localObject3).aLH();
      }
    }
    for (;;)
    {
      if (paramTabItem.dvm != 3) {
        break label379;
      }
      localObject1 = com.tencent.mm.game.report.c.guw;
      i = paramTabItem.position;
      localObject1 = paramTabItem.upi;
      l = j;
      p.h(localObject1, "tabKey");
      localObject2 = com.tencent.mm.game.report.c.a.a(1L, 101L, i, 71L, l);
      ((cf)localObject2).edK = 0L;
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("red_dot", 0);
      ((JSONObject)localObject3).put("tab_key", localObject1);
      ((cf)localObject2).lZ(URLEncoder.encode(((JSONObject)localObject3).toString()));
      ((cf)localObject2).aLH();
      com.tencent.mm.plugin.game.f.c.C(paramActivity, paramTabItem.uFj.ikm, paramTabItem.uFj.uuA);
      AppMethodBeat.o(195748);
      return;
      i = 0;
      break;
      ((Intent)localObject1).putExtra("disable_minimize", true);
    }
    label379:
    localObject1 = ((Intent)localObject1).getExtras();
    if (localObject1 == null) {
      localObject1 = new Bundle();
    }
    for (;;)
    {
      localObject2 = ((Bundle)localObject1).getString("from_source_activity");
      if (!bu.isNullOrNil((String)localObject2))
      {
        ae.i("MicroMsg.GameTabWidget2", "fromSourceActivity: %s", new Object[] { localObject2 });
        localObject3 = new Intent();
        ((Intent)localObject3).addFlags(65536);
        ((Intent)localObject3).addFlags(131072);
        ((Intent)localObject3).setClassName(paramActivity, (String)localObject2);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.overridePendingTransition(2130772069, 2130772069);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("from_game_tab", true);
      ((Bundle)localObject1).putString("game_tab_key", paramTabItem.upi);
      ((Bundle)localObject1).putInt("game_tab_type", paramTabItem.dvm);
      ((Bundle)localObject1).putLong("turn_page_time", System.currentTimeMillis());
      ((Bundle)localObject1).putString("rawUrl", paramTabItem.jumpUrl);
      ((Bundle)localObject1).putBoolean("from_find_more_friend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).setClassName(paramActivity, paramTabItem.upp);
      ((Intent)localObject2).addFlags(65536);
      ((Intent)localObject2).addFlags(131072);
      try
      {
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramBoolean)
        {
          paramActivity.overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
          AppMethodBeat.o(195748);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        ae.printErrStackTrace("MicroMsg.GameTabWidget2", paramActivity, "className:[%s]", new Object[] { paramTabItem.upp });
        AppMethodBeat.o(195748);
        return;
      }
      paramActivity.overridePendingTransition(2130772069, 2130772069);
      AppMethodBeat.o(195748);
      return;
    }
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(195746);
    this.mActivity = ((Activity)paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundResource(2131100428);
    setOrientation(0);
    AppMethodBeat.o(195746);
  }
  
  private void setAdapter(a parama)
  {
    AppMethodBeat.i(195747);
    this.uFq = parama;
    parama.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(195723);
        GameTabWidget2.b(GameTabWidget2.this);
        AppMethodBeat.o(195723);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(195722);
        GameTabWidget2.b(GameTabWidget2.this);
        AppMethodBeat.o(195722);
      }
    });
    parama.notifyDataSetChanged();
    AppMethodBeat.o(195747);
  }
  
  public final void a(GameTabData2 paramGameTabData2, String paramString)
  {
    AppMethodBeat.i(195742);
    if (paramGameTabData2 == null)
    {
      AppMethodBeat.o(195742);
      return;
    }
    Object localObject = new a(getContext());
    setAdapter((a)localObject);
    ((a)localObject).a(paramGameTabData2, paramString, this.mActivity.getIntent().getStringExtra("game_red_dot_tab_key"));
    int i = com.tencent.mm.plugin.game.f.c.parseColor(paramGameTabData2.jZm);
    int j = com.tencent.mm.plugin.game.f.c.parseColor(paramGameTabData2.uFb);
    if (al.isDarkMode()) {
      if (j != 0) {
        setBackgroundColor(j);
      }
    }
    while (this.mActivity.getIntent().getBooleanExtra("game_tab_exposure", true))
    {
      this.mActivity.getIntent().putExtra("game_tab_exposure", false);
      paramString = this.mActivity.getIntent().getStringExtra("game_tab_key");
      j = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      localObject = com.tencent.mm.game.report.c.guw;
      com.tencent.mm.game.report.c.a.s(paramString, j);
      paramString = paramGameTabData2.uEZ.entrySet().iterator();
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
          if (((GameTabData2.TabItem)localObject).upi.equals(paramGameTabData2.dcT()))
          {
            this.uFt = ((GameTabData2.TabItem)localObject);
            this.uFu = true;
            continue;
            if (i == 0) {
              break;
            }
            setBackgroundColor(i);
            break;
          }
          com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.guw;
          com.tencent.mm.game.report.c.a.a(i, 0, ((GameTabData2.TabItem)localObject).upi, 0, j);
        }
      }
    }
    label285:
    for (;;)
    {
      break;
      AppMethodBeat.o(195742);
      return;
    }
  }
  
  public final void dcW()
  {
    AppMethodBeat.i(195743);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195721);
        if (GameTabWidget2.a(GameTabWidget2.this) != null) {
          GameTabWidget2.a(GameTabWidget2.this).notifyDataSetInvalidated();
        }
        AppMethodBeat.o(195721);
      }
    });
    AppMethodBeat.o(195743);
  }
  
  public final void hi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195744);
    if (this.uFq != null) {
      this.uFq.hj(paramString1, paramString2);
    }
    AppMethodBeat.o(195744);
  }
  
  public void setChatMsgUnreadCount(int paramInt)
  {
    AppMethodBeat.i(195745);
    if ((this.uFu) && (this.uFt != null))
    {
      this.uFu = false;
      int i = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.guw;
      com.tencent.mm.game.report.c.a.a(this.uFt.position, paramInt, this.uFt.upi, 6, i);
    }
    if (this.uFq != null) {
      this.uFq.setChatMsgUnreadCount(paramInt);
    }
    AppMethodBeat.o(195745);
  }
  
  public void setPageChanging(boolean paramBoolean)
  {
    this.uFs = paramBoolean;
  }
  
  public void setTabSwitchEnable(boolean paramBoolean)
  {
    this.uFr = paramBoolean;
  }
  
  final class a
    extends BaseAdapter
  {
    private Context mContext;
    int uFA;
    private GameTabData2 uFw;
    private String uFx;
    private String uFy;
    Map<String, a> uFz;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(195727);
      this.uFz = new HashMap();
      this.uFA = 0;
      this.mContext = paramContext;
      AppMethodBeat.o(195727);
    }
    
    private void a(a parama, GameTabData2.TabItem paramTabItem, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(195735);
      parama.uFC.setVisibility(8);
      if (bu.nullAsNil(paramTabItem.upi).equalsIgnoreCase(paramString)) {
        parama.uFC.setVisibility(0);
      }
      if (al.isDarkMode())
      {
        i = bu(paramTabItem.uFe, paramBoolean);
        j = bu(paramTabItem.uFf, paramBoolean);
        str1 = paramTabItem.uFh;
        String str2 = paramTabItem.uFi;
        paramString = str2;
        if (bu.isNullOrNil(str2)) {
          paramString = str1;
        }
        str2 = paramString;
        paramString = str1;
        if (bu.isNullOrNil(str1))
        {
          paramString = paramTabItem.iconUrl;
          str2 = paramTabItem.uFg;
        }
        if (paramBoolean)
        {
          c(str2, parama.ka);
          parama.gqi.setTextColor(j);
          AppMethodBeat.o(195735);
          return;
        }
        c(paramString, parama.ka);
        parama.gqi.setTextColor(i);
        AppMethodBeat.o(195735);
        return;
      }
      int i = bu(paramTabItem.titleColor, paramBoolean);
      int j = bu(paramTabItem.uFd, paramBoolean);
      paramString = paramTabItem.iconUrl;
      String str1 = paramTabItem.uFg;
      paramTabItem = str1;
      if (bu.isNullOrNil(str1)) {
        paramTabItem = paramString;
      }
      if (paramBoolean)
      {
        c(paramTabItem, parama.ka);
        parama.gqi.setTextColor(j);
        AppMethodBeat.o(195735);
        return;
      }
      c(paramString, parama.ka);
      parama.gqi.setTextColor(i);
      AppMethodBeat.o(195735);
    }
    
    private int bu(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(195736);
      int j = com.tencent.mm.plugin.game.f.c.parseColor(paramString);
      int i = j;
      if (j == 0) {
        if (!paramBoolean) {
          break label43;
        }
      }
      label43:
      for (i = GameTabWidget2.this.getResources().getColor(2131100464);; i = GameTabWidget2.this.getResources().getColor(2131101228))
      {
        AppMethodBeat.o(195736);
        return i;
      }
    }
    
    private static void c(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(195734);
      if ((bu.isNullOrNil(paramString)) || (paramImageView == null))
      {
        AppMethodBeat.o(195734);
        return;
      }
      if (!bu.isNullOrNil(paramString))
      {
        Object localObject = GameTabWidget2.uFp + g.getMessageDigest(paramString.getBytes());
        com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
        locala.igk = true;
        locala.hgD = ((String)localObject);
        localObject = locala.aJu();
        com.tencent.mm.av.a.a.aJh().a(paramString, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
      }
      AppMethodBeat.o(195734);
    }
    
    private void l(TextView paramTextView, int paramInt)
    {
      AppMethodBeat.i(195730);
      if (paramInt >= 100)
      {
        paramTextView.setText("");
        paramTextView.setBackgroundResource(2131689744);
        paramTextView.setTextSize(0, com.tencent.mm.cb.a.ay(GameTabWidget2.this.getContext(), 2131166949));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(195730);
        return;
      }
      paramTextView.setText(String.valueOf(paramInt));
      paramTextView.setBackgroundResource(u.aP(GameTabWidget2.this.getContext(), paramInt));
      paramTextView.setTextSize(0, com.tencent.mm.cb.a.ay(GameTabWidget2.this.getContext(), 2131166949) * com.tencent.mm.cb.a.ip(GameTabWidget2.this.getContext()));
      paramTextView.setVisibility(0);
      AppMethodBeat.o(195730);
    }
    
    public final void a(GameTabData2 paramGameTabData2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(195728);
      this.uFw = paramGameTabData2;
      this.uFx = paramString1;
      this.uFy = paramString2;
      notifyDataSetChanged();
      AppMethodBeat.o(195728);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(195732);
      if (this.uFw == null)
      {
        AppMethodBeat.o(195732);
        return 0;
      }
      int i = this.uFw.afz().size();
      AppMethodBeat.o(195732);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(195733);
      paramView = LayoutInflater.from(this.mContext).inflate(2131496403, paramViewGroup, false);
      paramViewGroup = new a(paramView);
      if (com.tencent.mm.cb.a.ir(GameTabWidget2.this.getContext()))
      {
        paramViewGroup.gqi.setTextSize(0, com.tencent.mm.cb.a.ay(GameTabWidget2.this.getContext(), 2131167052) * com.tencent.mm.cb.a.ip(GameTabWidget2.this.getContext()));
        paramViewGroup.uFD.setTextSize(0, com.tencent.mm.cb.a.ay(GameTabWidget2.this.getContext(), 2131167052) * com.tencent.mm.cb.a.ip(GameTabWidget2.this.getContext()));
      }
      GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.uFw.afz().get(paramInt);
      if (localTabItem != null)
      {
        paramViewGroup.gqi.setText(localTabItem.title);
        a(paramViewGroup, localTabItem, bu.nullAsNil(this.uFx).equalsIgnoreCase(localTabItem.upi), this.uFy);
        this.uFz.put(localTabItem.upi, paramViewGroup);
      }
      paramView.setTag(localTabItem);
      AppMethodBeat.o(195733);
      return paramView;
    }
    
    public final void hj(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195731);
      this.uFy = paramString2;
      paramString2 = this.uFz.entrySet().iterator();
      while (paramString2.hasNext())
      {
        Object localObject = (Map.Entry)paramString2.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (a)((Map.Entry)localObject).getValue();
        GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.uFw.uEZ.get(str);
        if ((localObject != null) && (localTabItem != null)) {
          a((a)localObject, localTabItem, bu.nullAsNil(paramString1).equalsIgnoreCase(str), this.uFy);
        }
      }
      AppMethodBeat.o(195731);
    }
    
    public final void setChatMsgUnreadCount(int paramInt)
    {
      AppMethodBeat.i(195729);
      this.uFA = paramInt;
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        com.tencent.e.h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195725);
            GameTabWidget2.a.this.setChatMsgUnreadCount(GameTabWidget2.a.a(GameTabWidget2.a.this));
            AppMethodBeat.o(195725);
          }
        });
        AppMethodBeat.o(195729);
        return;
      }
      if (this.uFw != null)
      {
        Object localObject = this.uFw.dcT();
        localObject = (a)this.uFz.get(localObject);
        if (localObject != null)
        {
          ((a)localObject).uFD.setTag(Integer.valueOf(paramInt));
          if (paramInt > 0)
          {
            l(((a)localObject).uFD, paramInt);
            AppMethodBeat.o(195729);
            return;
          }
          ((a)localObject).uFD.setVisibility(4);
        }
      }
      AppMethodBeat.o(195729);
    }
    
    public final class a
    {
      TextView gqi;
      ImageView ka;
      ImageView uFC;
      TextView uFD;
      
      public a(View paramView)
      {
        AppMethodBeat.i(195726);
        this.gqi = ((TextView)paramView.findViewById(2131297471));
        this.ka = ((ImageView)paramView.findViewById(2131297469));
        this.uFC = ((ImageView)paramView.findViewById(2131308513));
        this.uFD = ((TextView)paramView.findViewById(2131300058));
        AppMethodBeat.o(195726);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2
 * JD-Core Version:    0.7.0.1
 */