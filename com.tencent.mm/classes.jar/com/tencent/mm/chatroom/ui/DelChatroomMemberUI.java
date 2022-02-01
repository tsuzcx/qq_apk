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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.roomsdk.a.b.b;
import com.tencent.mm.roomsdk.a.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String chatroomName;
  private x ftP;
  private a fuO;
  private LinkedList<String> fuP;
  private ListView mListView;
  private int scene;
  private p tipDialog;
  
  public DelChatroomMemberUI()
  {
    AppMethodBeat.i(12641);
    this.fuP = new LinkedList();
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
    this.fuO = new a();
    a locala = this.fuO;
    Object localObject = this.fuP;
    if (localObject != null)
    {
      ac.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.fuU.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
        if ((localai != null) && (!bs.isNullOrNil(localai.field_username)) && (localai.field_username.equals(str))) {
          locala.fuU.add(localai);
        }
      }
    }
    this.mListView.setAdapter(this.fuO);
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
      this.fuP.add(localObject);
      i += 1;
    }
    this.ftP = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(this.chatroomName);
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
    ac.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
    List<ai> fuU;
    
    a()
    {
      AppMethodBeat.i(12636);
      this.fuU = new LinkedList();
      AppMethodBeat.o(12636);
    }
    
    public final String b(ai paramai)
    {
      AppMethodBeat.i(12640);
      if (!bs.isNullOrNil(paramai.field_conRemark)) {}
      for (Object localObject2 = paramai.field_conRemark;; localObject2 = DelChatroomMemberUI.b(DelChatroomMemberUI.this, paramai.field_username))
      {
        Object localObject1 = localObject2;
        if (bs.isNullOrNil((String)localObject2)) {
          localObject1 = paramai.field_conRemark;
        }
        localObject2 = localObject1;
        if (bs.isNullOrNil((String)localObject1)) {
          localObject2 = paramai.aaR();
        }
        AppMethodBeat.o(12640);
        return localObject2;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12637);
      int i = this.fuU.size();
      AppMethodBeat.o(12637);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12638);
      Object localObject = this.fuU.get(paramInt);
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
        paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131297963));
        paramViewGroup.fuZ = ((TextView)paramView.findViewById(2131297964));
        paramViewGroup.fva = ((TextView)paramView.findViewById(2131297962));
        paramViewGroup.fva.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(12635);
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            paramAnonymousView = (ai)DelChatroomMemberUI.a.this.getItem(i);
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
        paramViewGroup.fva.setTag(Integer.valueOf(paramInt));
        ai localai = (ai)getItem(paramInt);
        String str = b(localai);
        paramViewGroup.fuZ.setText(str);
        com.tencent.mm.pluginsdk.ui.span.k.b(DelChatroomMemberUI.this, str, paramViewGroup.fuZ.getTextSize());
        a.b.c(paramViewGroup.fuY, localai.field_username);
        AppMethodBeat.o(12639);
        return paramView;
        paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
      }
    }
  }
  
  final class b
  {
    public ImageView fuY;
    public TextView fuZ;
    public TextView fva;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */