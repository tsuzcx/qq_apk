package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.roomsdk.a.b.b;
import com.tencent.mm.roomsdk.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String chatroomName;
  private w fql;
  private a frh;
  private LinkedList<String> fri;
  private ListView mListView;
  private int scene;
  private p tipDialog;
  
  public DelChatroomMemberUI()
  {
    AppMethodBeat.i(12641);
    this.fri = new LinkedList();
    AppMethodBeat.o(12641);
  }
  
  public int getLayoutId()
  {
    return 2131493375;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12645);
    setMMTitle(2131762610);
    this.mListView = ((ListView)findViewById(2131302235));
    this.frh = new a();
    a locala = this.frh;
    Object localObject = this.fri;
    if (localObject != null)
    {
      ad.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.frn.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
        if ((localaf != null) && (!bt.isNullOrNil(localaf.field_username)) && (localaf.field_username.equals(str))) {
          locala.frn.add(localaf);
        }
      }
    }
    this.mListView.setAdapter(this.frh);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12629);
        DelChatroomMemberUI.this.finish();
        AppMethodBeat.o(12629);
        return true;
      }
    });
    AppMethodBeat.o(12645);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(12642);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
    this.scene = getIntent().getIntExtra("scene", 0);
    paramBundle = getIntent().getStringExtra("members").split(",");
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.fri.add(localObject);
      i += 1;
    }
    this.fql = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(this.chatroomName);
    initView();
    AppMethodBeat.o(12642);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12643);
    super.onDestroy();
    AppMethodBeat.o(12643);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12644);
    super.onResume();
    AppMethodBeat.o(12644);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12646);
    ad.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(12646);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    List<af> frn;
    
    a()
    {
      AppMethodBeat.i(12636);
      this.frn = new LinkedList();
      AppMethodBeat.o(12636);
    }
    
    public final String b(af paramaf)
    {
      AppMethodBeat.i(12640);
      if (!bt.isNullOrNil(paramaf.field_conRemark)) {}
      for (Object localObject2 = paramaf.field_conRemark;; localObject2 = DelChatroomMemberUI.b(DelChatroomMemberUI.this, paramaf.field_username))
      {
        Object localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject1 = paramaf.field_conRemark;
        }
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject2 = paramaf.ZW();
        }
        AppMethodBeat.o(12640);
        return localObject2;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12637);
      int i = this.frn.size();
      AppMethodBeat.o(12637);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12638);
      Object localObject = this.frn.get(paramInt);
      AppMethodBeat.o(12638);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12639);
      if (paramView == null)
      {
        paramView = View.inflate(DelChatroomMemberUI.this, 2131493374, null);
        paramViewGroup = new DelChatroomMemberUI.b(DelChatroomMemberUI.this);
        paramViewGroup.frr = ((ImageView)paramView.findViewById(2131297963));
        paramViewGroup.frs = ((TextView)paramView.findViewById(2131297964));
        paramViewGroup.frt = ((TextView)paramView.findViewById(2131297962));
        paramViewGroup.frt.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(12635);
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            paramAnonymousView = (af)DelChatroomMemberUI.a.this.getItem(i);
            String str = DelChatroomMemberUI.this.getString(2131762599, new Object[] { DelChatroomMemberUI.a.this.b(paramAnonymousView) });
            h.a(DelChatroomMemberUI.this, str, null, DelChatroomMemberUI.this.getString(2131762607), DelChatroomMemberUI.this.getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(12634);
                DelChatroomMemberUI.a(DelChatroomMemberUI.this, paramAnonymousView.field_username);
                AppMethodBeat.o(12634);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(12635);
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.frt.setTag(Integer.valueOf(paramInt));
        af localaf = (af)getItem(paramInt);
        String str = b(localaf);
        paramViewGroup.frs.setText(str);
        com.tencent.mm.pluginsdk.ui.span.k.b(DelChatroomMemberUI.this, str, paramViewGroup.frs.getTextSize());
        a.b.c(paramViewGroup.frr, localaf.field_username);
        AppMethodBeat.o(12639);
        return paramView;
        paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
      }
    }
  }
  
  final class b
  {
    public ImageView frr;
    public TextView frs;
    public TextView frt;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */