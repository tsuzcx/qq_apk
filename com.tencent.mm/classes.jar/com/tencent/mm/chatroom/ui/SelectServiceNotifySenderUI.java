package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectServiceNotifySenderUI
  extends MMActivity
{
  protected int lCR;
  private MMEditText lMy;
  protected a lNE;
  private List<b> lNF;
  private View lNf;
  private SelectMemberScrollBar lNg;
  private boolean lNk;
  private TextView lNm;
  private ListView mListView;
  protected String mTitle;
  
  public SelectServiceNotifySenderUI()
  {
    AppMethodBeat.i(241644);
    this.lNF = new ArrayList();
    AppMethodBeat.o(241644);
  }
  
  public static boolean aNl()
  {
    return false;
  }
  
  protected static HashSet<String> aNs()
  {
    AppMethodBeat.i(241649);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(241649);
    return localHashSet;
  }
  
  protected final void R(View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(241676);
    this.lMy.clearFocus();
    Util.hideVKB(paramView);
    paramView = this.lNE.hSb;
    if ((paramView == null) || (paramView.size() < paramInt))
    {
      if (paramView == null) {}
      for (;;)
      {
        Log.e("MicroMsg.SelectServiceNotifySenderUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(241676);
        return;
        i = paramView.size();
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", Util.nullAsNil("notifymessage"));
    localIntent.putExtra("key_notify_message_real_username", ((b)paramView.get(paramInt)).username);
    localIntent.putExtra("finish_direct", true);
    localIntent.putExtra("chat_from_scene", 6);
    c.g(getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(241676);
  }
  
  protected final List<b> aNv()
  {
    AppMethodBeat.i(241683);
    this.lNF.clear();
    Object localObject1 = ((com.tencent.mm.message.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.message.b.b.class)).getNotifyMessageRecordStorage().Ho(null);
    if (localObject1 == null)
    {
      localObject1 = this.lNF;
      AppMethodBeat.o(241683);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        ((Cursor)localObject1).moveToFirst();
        if (((Cursor)localObject1).isAfterLast()) {
          break label266;
        }
        localb = new b((byte)0);
        localb.nickname = ((Cursor)localObject1).getString(0);
        localb.username = ((Cursor)localObject1).getString(1);
        localb.lNL = ((Cursor)localObject1).getInt(2);
        if (Util.isNullOrNil(localb.nickname))
        {
          if (!localb.username.endsWith("@app")) {
            continue;
          }
          localObject3 = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(localb.username);
          if (localObject3 != null) {
            localb.nickname = ((WxaAttributes)localObject3).field_nickname;
          }
        }
      }
      catch (Exception localException)
      {
        b localb;
        Object localObject3;
        Log.printErrStackTrace("MicroMsg.SelectServiceNotifySenderUI", localException, "", new Object[0]);
        ((Cursor)localObject1).close();
        localObject1 = this.lNF;
        AppMethodBeat.o(241683);
        return localObject1;
        localException.nickname = aa.getDisplayName(localException.username);
        continue;
      }
      finally
      {
        ((Cursor)localObject1).close();
        AppMethodBeat.o(241683);
      }
      localObject3 = new au(localb.username);
      ((au)localObject3).setNickname(localb.nickname);
      localb.contact = ((au)localObject3);
      this.lNF.add(localb);
      ((Cursor)localObject1).moveToNext();
    }
    for (;;)
    {
      label266:
      ((Cursor)localObject1).close();
    }
  }
  
  public int getLayoutId()
  {
    return a.f.lGC;
  }
  
  public void initView()
  {
    AppMethodBeat.i(241669);
    setMMTitle(Util.nullAsNil(this.mTitle));
    this.mListView = ((ListView)findViewById(a.e.fOe));
    this.mListView.setBackgroundResource(a.b.BW_93);
    this.lNf = findViewById(a.e.lFx);
    this.lNm = ((TextView)findViewById(a.e.empty_tv));
    this.lNE = new a(this);
    new HashSet().add(z.bAM());
    this.mListView.setAdapter(this.lNE);
    this.lNg = ((SelectMemberScrollBar)findViewById(a.e.fOf));
    this.lNg.setOnScrollBarTouchListener(new VerticalScrollBar.a()
    {
      public final void onScollBarTouch(String paramAnonymousString)
      {
        AppMethodBeat.i(241730);
        if ("↑".equals(paramAnonymousString))
        {
          SelectServiceNotifySenderUI.a(SelectServiceNotifySenderUI.this).setSelection(0);
          AppMethodBeat.o(241730);
          return;
        }
        SelectServiceNotifySenderUI.a locala = SelectServiceNotifySenderUI.this.lNE;
        if (locala.lNs.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)locala.lNs.get(paramAnonymousString)).intValue();; i = -1)
        {
          if (i != -1) {
            SelectServiceNotifySenderUI.a(SelectServiceNotifySenderUI.this).setSelection(i);
          }
          AppMethodBeat.o(241730);
          return;
        }
      }
    });
    this.lNg.setVisibility(0);
    this.lMy = ((MMEditText)findViewById(a.e.fVL));
    this.lMy.addTextChangedListener(new TextWatcher()
    {
      private MTimerHandler lNo;
      
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(241750);
        this.lNo.stopTimer();
        this.lNo.startTimer(500L);
        AppMethodBeat.o(241750);
      }
    });
    a locala = this.lNE;
    locala.lNG.lNf.setVisibility(0);
    com.tencent.mm.kernel.h.baH().postToWorker(new SelectServiceNotifySenderUI.a.1(locala));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(241752);
        paramAnonymousMenuItem = new Intent();
        SelectServiceNotifySenderUI.this.setResult(0, paramAnonymousMenuItem);
        SelectServiceNotifySenderUI.this.finish();
        AppMethodBeat.o(241752);
        return true;
      }
    });
    AppMethodBeat.o(241669);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(241664);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectServiceNotifySenderUI", "[onCreate]");
    this.lCR = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.lNk = getIntent().getBooleanExtra("is_show_owner", true);
    initView();
    AppMethodBeat.o(241664);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends BaseAdapter
  {
    List<SelectServiceNotifySenderUI.b> hSb;
    volatile boolean isLoading;
    public String lMG;
    private String lMI;
    List<SelectServiceNotifySenderUI.b> lMJ;
    public final String lNr;
    HashMap<String, Integer> lNs;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(241617);
      this.lNr = new String(Character.toChars(91));
      this.lMI = null;
      this.lMJ = new ArrayList(0);
      this.hSb = new ArrayList();
      this.isLoading = false;
      this.lNs = new HashMap();
      this.mContext = paramContext;
      AppMethodBeat.o(241617);
    }
    
    private SelectServiceNotifySenderUI.b qG(int paramInt)
    {
      AppMethodBeat.i(241619);
      if (this.hSb.size() > paramInt)
      {
        SelectServiceNotifySenderUI.b localb = (SelectServiceNotifySenderUI.b)this.hSb.get(paramInt);
        AppMethodBeat.o(241619);
        return localb;
      }
      AppMethodBeat.o(241619);
      return null;
    }
    
    public final void bv(List<SelectServiceNotifySenderUI.b> paramList)
    {
      AppMethodBeat.i(241663);
      if (paramList == null)
      {
        AppMethodBeat.o(241663);
        return;
      }
      this.hSb.clear();
      int i = 0;
      while (i < paramList.size())
      {
        SelectServiceNotifySenderUI.b localb = (SelectServiceNotifySenderUI.b)paramList.get(i);
        au localau = localb.contact;
        if (((SelectServiceNotifySenderUI.aNl()) || (!z.Iy(localau.field_username))) && ((!localau.field_username.equals(this.lMI)) || (SelectServiceNotifySenderUI.e(SelectServiceNotifySenderUI.this))) && (!SelectServiceNotifySenderUI.aNs().contains(localau.field_username))) {
          this.hSb.add(localb);
        }
        i += 1;
      }
      Collections.sort(this.hSb, new Comparator() {});
      this.lMJ = this.hSb;
      AppMethodBeat.o(241663);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(241640);
      if ((this.hSb == null) || (this.isLoading))
      {
        AppMethodBeat.o(241640);
        return 0;
      }
      int i = this.hSb.size();
      AppMethodBeat.o(241640);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(241657);
      Object localObject1;
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, a.f.fts_servicenotify_sender_item, null);
        paramViewGroup = new SelectServiceNotifySenderUI.c();
        localObject1 = (WindowManager)this.mContext.getSystemService("window");
        paramViewGroup.lBC = ((ImageView)paramView.findViewById(a.e.avatar_iv));
        paramViewGroup.lDe = ((TextView)paramView.findViewById(a.e.nickname_tv));
        paramViewGroup.lDe.setMaxWidth(((WindowManager)localObject1).getDefaultDisplay().getWidth() * 2 / 3);
        paramViewGroup.lNN = ((TextView)paramView.findViewById(a.e.msg_counter_tv));
        paramViewGroup.lNO = paramView.findViewById(a.e.msg_divider);
        paramView.setTag(paramViewGroup);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(241706);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectServiceNotifySenderUI$ServiceNotifyAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            localObject = (SelectServiceNotifySenderUI.c)paramAnonymousView.getTag();
            SelectServiceNotifySenderUI localSelectServiceNotifySenderUI = SelectServiceNotifySenderUI.this;
            int i = ((SelectServiceNotifySenderUI.c)localObject).position;
            paramAnonymousView.getId();
            localSelectServiceNotifySenderUI.R(paramAnonymousView, i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectServiceNotifySenderUI$ServiceNotifyAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241706);
          }
        });
      }
      for (;;)
      {
        localObject1 = qG(paramInt);
        if (localObject1 != null) {
          break;
        }
        Log.e("MicroMsg.ServiceNotifyAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(241657);
        return paramView;
        paramViewGroup = (SelectServiceNotifySenderUI.c)paramView.getTag();
      }
      Object localObject2;
      int i;
      if (paramInt < getCount() - 1)
      {
        paramViewGroup.lNO.setVisibility(0);
        localObject2 = ((SelectServiceNotifySenderUI.b)localObject1).contact;
        com.tencent.mm.pluginsdk.ui.a.b.h(paramViewGroup.lBC, ((az)localObject2).field_username);
        localObject2 = ((au)localObject2).aSU();
        if (this.lMJ == this.hSb) {
          break label342;
        }
        i = 1;
        label252:
        if (i != 0) {
          break label348;
        }
        paramViewGroup.lDe.setText(p.b(this.mContext, (CharSequence)localObject2, paramViewGroup.lDe.getTextSize()));
      }
      for (;;)
      {
        paramViewGroup.lNN.setText(SelectServiceNotifySenderUI.this.getString(a.i.search_service_notify_msg_count_wording, new Object[] { Integer.valueOf(((SelectServiceNotifySenderUI.b)localObject1).lNL) }));
        paramViewGroup.lNM = ((SelectServiceNotifySenderUI.b)localObject1);
        paramViewGroup.position = paramInt;
        AppMethodBeat.o(241657);
        return paramView;
        paramViewGroup.lNO.setVisibility(8);
        break;
        label342:
        i = 0;
        break label252;
        label348:
        localObject2 = g.c((CharSequence)localObject2, this.lMG);
        ((g)localObject2).dso = paramViewGroup.lDe.getPaint();
        localObject2 = f.a((g)localObject2).HsX;
        paramViewGroup.lDe.setText((CharSequence)localObject2);
      }
    }
  }
  
  static final class b
  {
    public au contact;
    public int lNL;
    public String nickname;
    public String username;
  }
  
  protected static final class c
  {
    public ImageView lBC;
    public TextView lDe;
    public SelectServiceNotifySenderUI.b lNM;
    public TextView lNN;
    public View lNO;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectServiceNotifySenderUI
 * JD-Core Version:    0.7.0.1
 */