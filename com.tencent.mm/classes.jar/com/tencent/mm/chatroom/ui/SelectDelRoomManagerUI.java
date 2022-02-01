package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectDelRoomManagerUI
  extends SelectMemberUI
{
  private boolean lMQ;
  private List<String> lNb;
  
  public SelectDelRoomManagerUI()
  {
    AppMethodBeat.i(12939);
    this.lMQ = false;
    this.lNb = new ArrayList();
    AppMethodBeat.o(12939);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(12946);
    if (this.lNj.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12946);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12946);
  }
  
  protected final void a(View paramView, LinearLayout paramLinearLayout, ImageButton paramImageButton, int paramInt, String paramString)
  {
    AppMethodBeat.i(241731);
    super.a(paramView, paramLinearLayout, paramImageButton, paramInt, paramString);
    aNr();
    AppMethodBeat.o(241731);
  }
  
  protected final void aNn()
  {
    AppMethodBeat.i(12940);
    super.aNn();
    Object localObject1 = getIntent().getStringExtra("RoomManagers");
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.lNb.add(localObject2);
        i += 1;
      }
    }
    this.lMQ = true;
    AppMethodBeat.o(12940);
  }
  
  public final boolean aNo()
  {
    return true;
  }
  
  protected final boolean aNp()
  {
    return false;
  }
  
  protected final boolean aNt()
  {
    return false;
  }
  
  protected final BaseAdapter aNu()
  {
    AppMethodBeat.i(12944);
    BaseAdapter localBaseAdapter = super.aNu();
    AppMethodBeat.o(12944);
    return localBaseAdapter;
  }
  
  protected final List<String> aNv()
  {
    return this.lNb;
  }
  
  public void finish()
  {
    AppMethodBeat.i(12942);
    hideVKB();
    super.finish();
    AppMethodBeat.o(12942);
  }
  
  public void initView()
  {
    AppMethodBeat.i(12941);
    super.initView();
    String str;
    label45:
    MenuItem.OnMenuItemClickListener local1;
    if (this.lMQ)
    {
      str = getString(a.i.lIQ);
      setMMTitle(str);
      if (!this.lMQ) {
        break label96;
      }
      str = getString(a.i.delete_room_member);
      local1 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12938);
          if (SelectDelRoomManagerUI.a(SelectDelRoomManagerUI.this))
          {
            paramAnonymousMenuItem = ((b)h.ax(b.class)).bzK().Ju(SelectDelRoomManagerUI.this.lyn);
            StringBuilder localStringBuilder = new StringBuilder();
            Iterator localIterator = SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this).iterator();
            while (localIterator.hasNext()) {
              localStringBuilder.append(ab.b(paramAnonymousMenuItem, (String)localIterator.next())).append("、");
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
            }
            k.a(SelectDelRoomManagerUI.this, SelectDelRoomManagerUI.this.getString(a.i.lIj, new Object[] { localStringBuilder }), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(12937);
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("Select_Contact", Util.listToString(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
                SelectDelRoomManagerUI.this.setResult(-1, paramAnonymous2DialogInterface);
                SelectDelRoomManagerUI.this.finish();
                AppMethodBeat.o(12937);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(12938);
            return true;
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
          SelectDelRoomManagerUI.this.setResult(-1, paramAnonymousMenuItem);
          SelectDelRoomManagerUI.this.finish();
          AppMethodBeat.o(12938);
          return true;
        }
      };
      if (!this.lMQ) {
        break label107;
      }
    }
    label96:
    label107:
    for (y.b localb = y.b.adEK;; localb = y.b.adEJ)
    {
      addTextOptionMenu(1, str, local1, null, localb);
      aNr();
      AppMethodBeat.o(12941);
      return;
      str = getString(a.i.lIP);
      break;
      str = getString(a.i.app_finish);
      break label45;
    }
  }
  
  protected final void onItemClick(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12943);
    super.onItemClick(paramView, paramInt, paramLong);
    ((SelectMemberUI.c)paramView.getTag()).lNB.performClick();
    AppMethodBeat.o(12943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */