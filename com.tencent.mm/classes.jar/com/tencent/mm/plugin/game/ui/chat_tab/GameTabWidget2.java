package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
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
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.al;
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
  private static final String utW;
  private Activity mActivity;
  private a utX;
  private boolean utY;
  private GameTabData2.TabItem utZ;
  private boolean uua;
  
  static
  {
    AppMethodBeat.i(206927);
    utW = com.tencent.mm.plugin.game.commlib.util.b.a(b.a.tTf) + "tabnav/";
    AppMethodBeat.o(206927);
  }
  
  public GameTabWidget2(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206916);
    this.utY = true;
    this.uua = false;
    aM(paramContext);
    AppMethodBeat.o(206916);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206917);
    this.utY = true;
    this.uua = false;
    aM(paramContext);
    AppMethodBeat.o(206917);
  }
  
  public GameTabWidget2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206918);
    this.utY = true;
    this.uua = false;
    aM(paramContext);
    AppMethodBeat.o(206918);
  }
  
  public static void a(Activity paramActivity, GameTabData2.TabItem paramTabItem, boolean paramBoolean)
  {
    AppMethodBeat.i(206925);
    if ((paramActivity == null) || (paramTabItem == null))
    {
      AppMethodBeat.o(206925);
      return;
    }
    int j = paramActivity.getIntent().getIntExtra("game_report_from_scene", 0);
    int i;
    long l;
    Object localObject2;
    Object localObject3;
    if (!paramBoolean) {
      if (paramTabItem.duh == 1)
      {
        i = 6;
        localObject1 = com.tencent.mm.game.report.c.grV;
        int k = paramTabItem.position;
        int m = paramTabItem.utU;
        localObject1 = paramTabItem.uea;
        l = j;
        p.h(localObject1, "tabKey");
        localObject2 = com.tencent.mm.game.report.c.a.a(1L, 101L, k, 2L, l);
        ((cf)localObject2).ecp = m;
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("red_dot", i);
        ((JSONObject)localObject3).put("tab_key", localObject1);
        ((cf)localObject2).lI(URLEncoder.encode(((JSONObject)localObject3).toString()));
        ((cf)localObject2).aLk();
      }
    }
    for (;;)
    {
      if (paramTabItem.duh != 3) {
        break label303;
      }
      localObject1 = com.tencent.mm.game.report.c.grV;
      i = paramTabItem.position;
      localObject1 = paramTabItem.uea;
      l = j;
      p.h(localObject1, "tabKey");
      localObject2 = com.tencent.mm.game.report.c.a.a(1L, 101L, i, 71L, l);
      ((cf)localObject2).ecp = 0L;
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("red_dot", 0);
      ((JSONObject)localObject3).put("tab_key", localObject1);
      ((cf)localObject2).lI(URLEncoder.encode(((JSONObject)localObject3).toString()));
      ((cf)localObject2).aLk();
      com.tencent.mm.plugin.game.f.c.C(paramActivity, paramTabItem.utQ.iht, paramTabItem.utQ.ujc);
      AppMethodBeat.o(206925);
      return;
      i = 0;
      break;
      paramActivity.getIntent().putExtra("disable_minimize", true);
    }
    label303:
    Object localObject1 = paramActivity.getIntent();
    if (localObject1 == null)
    {
      AppMethodBeat.o(206925);
      return;
    }
    localObject1 = ((Intent)localObject1).getExtras();
    if (localObject1 == null) {
      localObject1 = new Bundle();
    }
    for (;;)
    {
      localObject2 = ((Bundle)localObject1).getString("from_source_activity");
      if (!bt.isNullOrNil((String)localObject2))
      {
        ad.i("MicroMsg.GameTabWidget2", "fromSourceActivity: %s", new Object[] { localObject2 });
        localObject3 = new Intent();
        ((Intent)localObject3).addFlags(65536);
        ((Intent)localObject3).addFlags(131072);
        ((Intent)localObject3).setClassName(paramActivity, (String)localObject2);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.overridePendingTransition(2130772069, 2130772069);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("from_game_tab", true);
      ((Bundle)localObject1).putString("game_tab_key", paramTabItem.uea);
      ((Bundle)localObject1).putInt("game_tab_type", paramTabItem.duh);
      ((Bundle)localObject1).putLong("turn_page_time", System.currentTimeMillis());
      ((Bundle)localObject1).putString("rawUrl", paramTabItem.jumpUrl);
      ((Bundle)localObject1).putBoolean("from_find_more_friend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).setClassName(paramActivity, paramTabItem.uei);
      ((Intent)localObject2).addFlags(65536);
      ((Intent)localObject2).addFlags(131072);
      try
      {
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramBoolean)
        {
          paramActivity.overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
          AppMethodBeat.o(206925);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        ad.printErrStackTrace("MicroMsg.GameTabWidget2", paramActivity, "className:[%s]", new Object[] { paramTabItem.uei });
        AppMethodBeat.o(206925);
        return;
      }
      paramActivity.overridePendingTransition(2130772069, 2130772069);
      AppMethodBeat.o(206925);
      return;
    }
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(206923);
    this.mActivity = ((Activity)paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundResource(2131100428);
    setOrientation(0);
    AppMethodBeat.o(206923);
  }
  
  private void setAdapter(a parama)
  {
    AppMethodBeat.i(206924);
    this.utX = parama;
    parama.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(206901);
        GameTabWidget2.b(GameTabWidget2.this);
        AppMethodBeat.o(206901);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(206900);
        GameTabWidget2.b(GameTabWidget2.this);
        AppMethodBeat.o(206900);
      }
    });
    parama.notifyDataSetChanged();
    AppMethodBeat.o(206924);
  }
  
  public final void a(GameTabData2 paramGameTabData2, String paramString)
  {
    AppMethodBeat.i(206919);
    if (paramGameTabData2 == null)
    {
      AppMethodBeat.o(206919);
      return;
    }
    Object localObject = new a(getContext());
    setAdapter((a)localObject);
    ((a)localObject).b(paramGameTabData2, paramString);
    int i = com.tencent.mm.plugin.game.f.c.parseColor(paramGameTabData2.jVX);
    int j = com.tencent.mm.plugin.game.f.c.parseColor(paramGameTabData2.utI);
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
      localObject = com.tencent.mm.game.report.c.grV;
      com.tencent.mm.game.report.c.a.s(paramString, j);
      paramString = paramGameTabData2.utG.entrySet().iterator();
      i = 0;
      for (;;)
      {
        if (paramString.hasNext())
        {
          localObject = (GameTabData2.TabItem)((Map.Entry)paramString.next()).getValue();
          if (localObject == null) {
            break label273;
          }
          i += 1;
          if (((GameTabData2.TabItem)localObject).uea.equals(paramGameTabData2.dai()))
          {
            this.utZ = ((GameTabData2.TabItem)localObject);
            this.uua = true;
            continue;
            if (i == 0) {
              break;
            }
            setBackgroundColor(i);
            break;
          }
          com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.grV;
          com.tencent.mm.game.report.c.a.a(i, 0, ((GameTabData2.TabItem)localObject).uea, 0, j);
        }
      }
    }
    label273:
    for (;;)
    {
      break;
      AppMethodBeat.o(206919);
      return;
    }
  }
  
  public final void amo(String paramString)
  {
    AppMethodBeat.i(206921);
    if (this.utX != null) {
      this.utX.amp(paramString);
    }
    AppMethodBeat.o(206921);
  }
  
  public final void dal()
  {
    AppMethodBeat.i(206920);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206899);
        if (GameTabWidget2.a(GameTabWidget2.this) != null) {
          GameTabWidget2.a(GameTabWidget2.this).notifyDataSetInvalidated();
        }
        AppMethodBeat.o(206899);
      }
    });
    AppMethodBeat.o(206920);
  }
  
  public void setChatMsgUnreadCount(int paramInt)
  {
    AppMethodBeat.i(206922);
    if ((this.uua) && (this.utZ != null))
    {
      this.uua = false;
      int i = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
      com.tencent.mm.game.report.c.a locala = com.tencent.mm.game.report.c.grV;
      com.tencent.mm.game.report.c.a.a(this.utZ.position, paramInt, this.utZ.uea, 6, i);
    }
    if (this.utX != null) {
      this.utX.setChatMsgUnreadCount(paramInt);
    }
    AppMethodBeat.o(206922);
  }
  
  public void setTabSwitchEnable(boolean paramBoolean)
  {
    this.utY = paramBoolean;
  }
  
  final class a
    extends BaseAdapter
  {
    private Context mContext;
    private GameTabData2 uuc;
    private String uud;
    Map<String, a> uue;
    int uuf;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(206905);
      this.uue = new HashMap();
      this.uuf = 0;
      this.mContext = paramContext;
      AppMethodBeat.o(206905);
    }
    
    private void a(a parama, GameTabData2.TabItem paramTabItem, boolean paramBoolean)
    {
      AppMethodBeat.i(206912);
      if (al.isDarkMode())
      {
        i = br(paramTabItem.utL, paramBoolean);
        j = br(paramTabItem.utM, paramBoolean);
        str = paramTabItem.utO;
        Object localObject2 = paramTabItem.utP;
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject1 = str;
        }
        localObject2 = localObject1;
        localObject1 = str;
        if (bt.isNullOrNil(str))
        {
          localObject1 = paramTabItem.iconUrl;
          localObject2 = paramTabItem.utN;
        }
        if (paramBoolean)
        {
          c((String)localObject2, parama.ka);
          parama.gnM.setTextColor(j);
          AppMethodBeat.o(206912);
          return;
        }
        c((String)localObject1, parama.ka);
        parama.gnM.setTextColor(i);
        AppMethodBeat.o(206912);
        return;
      }
      int i = br(paramTabItem.titleColor, paramBoolean);
      int j = br(paramTabItem.utK, paramBoolean);
      Object localObject1 = paramTabItem.iconUrl;
      String str = paramTabItem.utN;
      paramTabItem = str;
      if (bt.isNullOrNil(str)) {
        paramTabItem = (GameTabData2.TabItem)localObject1;
      }
      if (paramBoolean)
      {
        c(paramTabItem, parama.ka);
        parama.gnM.setTextColor(j);
        AppMethodBeat.o(206912);
        return;
      }
      c((String)localObject1, parama.ka);
      parama.gnM.setTextColor(i);
      AppMethodBeat.o(206912);
    }
    
    private int br(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(206913);
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
        AppMethodBeat.o(206913);
        return i;
      }
    }
    
    private static void c(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(206911);
      if ((bt.isNullOrNil(paramString)) || (paramImageView == null))
      {
        AppMethodBeat.o(206911);
        return;
      }
      if (!bt.isNullOrNil(paramString))
      {
        Object localObject = GameTabWidget2.utW + g.getMessageDigest(paramString.getBytes());
        com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
        locala.idr = true;
        locala.hdP = ((String)localObject);
        localObject = locala.aJc();
        com.tencent.mm.aw.a.a.aIP().a(paramString, paramImageView, (com.tencent.mm.aw.a.a.c)localObject);
      }
      AppMethodBeat.o(206911);
    }
    
    public final void amp(String paramString)
    {
      AppMethodBeat.i(206908);
      Iterator localIterator = this.uue.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (a)((Map.Entry)localObject).getValue();
        GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.uuc.utG.get(str);
        if ((localObject != null) && (localTabItem != null)) {
          a((a)localObject, localTabItem, bt.nullAsNil(paramString).equalsIgnoreCase(str));
        }
      }
      AppMethodBeat.o(206908);
    }
    
    public final void b(GameTabData2 paramGameTabData2, String paramString)
    {
      AppMethodBeat.i(206906);
      this.uuc = paramGameTabData2;
      this.uud = paramString;
      notifyDataSetChanged();
      AppMethodBeat.o(206906);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(206909);
      if (this.uuc == null)
      {
        AppMethodBeat.o(206909);
        return 0;
      }
      int i = this.uuc.afl().size();
      AppMethodBeat.o(206909);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(206910);
      paramView = LayoutInflater.from(this.mContext).inflate(2131496403, paramViewGroup, false);
      paramViewGroup = new a(paramView);
      GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)this.uuc.afl().get(paramInt);
      if (localTabItem != null)
      {
        paramViewGroup.gnM.setText(localTabItem.title);
        a(paramViewGroup, localTabItem, bt.nullAsNil(this.uud).equalsIgnoreCase(localTabItem.uea));
        this.uue.put(localTabItem.uea, paramViewGroup);
      }
      paramView.setTag(localTabItem);
      AppMethodBeat.o(206910);
      return paramView;
    }
    
    public final void setChatMsgUnreadCount(final int paramInt)
    {
      AppMethodBeat.i(206907);
      this.uuf = paramInt;
      GameTabWidget2.this.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206903);
          if (GameTabWidget2.a.a(GameTabWidget2.a.this) != null)
          {
            Object localObject = GameTabWidget2.a.a(GameTabWidget2.a.this).dai();
            localObject = (GameTabWidget2.a.a)GameTabWidget2.a.b(GameTabWidget2.a.this).get(localObject);
            if (localObject != null)
            {
              ((GameTabWidget2.a.a)localObject).uuh.setTag(Integer.valueOf(paramInt));
              if (paramInt > 0)
              {
                GameTabWidget2.a.a(GameTabWidget2.a.this, ((GameTabWidget2.a.a)localObject).uuh, paramInt);
                AppMethodBeat.o(206903);
                return;
              }
              ((GameTabWidget2.a.a)localObject).uuh.setVisibility(4);
            }
          }
          AppMethodBeat.o(206903);
        }
      });
      AppMethodBeat.o(206907);
    }
    
    public final class a
    {
      TextView gnM;
      ImageView ka;
      TextView uuh;
      
      public a(View paramView)
      {
        AppMethodBeat.i(206904);
        this.gnM = ((TextView)paramView.findViewById(2131297471));
        this.ka = ((ImageView)paramView.findViewById(2131297469));
        this.uuh = ((TextView)paramView.findViewById(2131300058));
        AppMethodBeat.o(206904);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2
 * JD-Core Version:    0.7.0.1
 */