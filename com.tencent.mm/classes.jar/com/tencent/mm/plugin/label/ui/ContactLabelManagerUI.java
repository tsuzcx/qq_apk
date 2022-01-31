package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.label.b.b;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI
  extends ContactLabelBaseUI
  implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener, f, n.d
{
  private ListView Nn;
  private int adz;
  private int idy = 0;
  private int idz = 0;
  private com.tencent.mm.ui.widget.b.a iep;
  private View jdP;
  private ContactLabelManagerUI.b lBm = ContactLabelManagerUI.b.lBB;
  private View lBn;
  private View lBo;
  private a lBp;
  private ArrayList<af> lBq = new ArrayList();
  private HashMap<Integer, Integer> lBr = new HashMap();
  private boolean lBs = true;
  private View.OnClickListener lBt = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      ContactLabelManagerUI.b(ContactLabelManagerUI.this);
    }
  };
  private j.a lBu = new j.a()
  {
    public final void a(String paramAnonymousString, l paramAnonymousl)
    {
      if (!bk.bl(paramAnonymousString)) {
        ContactLabelManagerUI.a(ContactLabelManagerUI.this);
      }
    }
  };
  private m.b lBv = new m.b()
  {
    public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.m paramAnonymousm, Object paramAnonymousObject)
    {
      y.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
      if (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null)
      {
        ContactLabelManagerUI.c(ContactLabelManagerUI.this).removeMessages(5001);
        ContactLabelManagerUI.c(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5001, 400L);
      }
    }
  };
  private ah mHandler = new ContactLabelManagerUI.1(this);
  
  private void Gt(String paramString)
  {
    if (!e.bdz().jJ(paramString))
    {
      y.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
      bdH();
      return;
    }
    bdC();
    hf(false);
  }
  
  private void bdH()
  {
    bdC();
    AY(getString(R.l.del_label_failed_msg));
  }
  
  private void hf(boolean paramBoolean)
  {
    try
    {
      y.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[] { String.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.mHandler != null)) {
        this.mHandler.sendEmptyMessageDelayed(5002, 400L);
      }
      au.DS().O(new ContactLabelManagerUI.4(this, paramBoolean));
      return;
    }
    finally {}
  }
  
  protected final int getLayoutId()
  {
    return R.i.contact_label_manager_ui;
  }
  
  protected final void initView()
  {
    this.adz = com.tencent.mm.cb.a.aa(this.mController.uMN, R.f.NormalTextSize);
    setMMTitle(getString(R.l.label_all_title));
    addTextOptionMenu(0, getString(R.l.label_new_short), new ContactLabelManagerUI.9(this));
    setBackBtn(new ContactLabelManagerUI.10(this));
    this.lBp = new a();
    this.jdP = findViewById(R.h.label_main);
    this.lBn = findViewById(R.h.label_empty);
    this.lBo = findViewById(R.h.label_new_btn);
    this.lBo.setOnClickListener(this.lBt);
    this.Nn = ((ListView)findViewById(R.h.label_list));
    this.iep = new com.tencent.mm.ui.widget.b.a(this);
    this.Nn.setOnTouchListener(new ContactLabelManagerUI.11(this));
    this.Nn.setOnItemLongClickListener(new ContactLabelManagerUI.12(this));
    this.Nn.setAdapter(this.lBp);
    this.Nn.setOnItemClickListener(this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      String str = paramIntent.getStringExtra("Select_Contact");
      y.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { str });
      if (!bk.bl(str))
      {
        Intent localIntent = new Intent(paramIntent);
        localIntent.putExtra("label_source", "label_source_Address");
        localIntent.setClass(this, ContactLabelEditUI.class);
        localIntent.putExtra("Select_Contact", str);
        startActivity(localIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    au.DS().O(new ContactLabelManagerUI.13(this));
    e.bdz().c(this.lBu);
    com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2) });
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int i = ((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).position;
    if ((this.lBp != null) && (i >= 0))
    {
      af localaf = this.lBp.sW(i);
      if (localaf != null)
      {
        paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), localaf.field_labelName));
        paramContextMenu.add(0, 0, 0, getString(R.l.app_delete));
        paramContextMenu.add(0, 1, 1, getString(R.l.app_edit));
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  protected void onDestroy()
  {
    e.bdz().d(this.lBu);
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.lBp != null) && (paramInt >= 0))
    {
      paramView = this.lBp.sW(paramInt);
      if (paramView != null)
      {
        paramAdapterView = paramView.field_labelID;
        paramView = paramView.field_labelName;
        Intent localIntent = new Intent();
        localIntent.putExtra("label_id", paramAdapterView);
        localIntent.putExtra("label_name", paramView);
        localIntent.putExtra("label_source", "label_source_Address");
        localIntent.setClass(this, ContactLabelEditUI.class);
        startActivity(localIntent);
        if (bk.bl(paramAdapterView))
        {
          if ((this.lBq != null) && (!this.lBq.isEmpty())) {
            break label156;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
        }
      }
    }
    return;
    label156:
    com.tencent.mm.plugin.report.service.h.nFQ.f(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if ((this.lBp != null) && (i >= 0)) {
      paramMenuItem = this.lBp.sW(i);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      com.tencent.mm.ui.base.h.a(this, getString(R.l.label_delete_confirm), "", getString(R.l.app_delete), getString(R.l.app_cancel), new ContactLabelManagerUI.2(this, paramMenuItem), new ContactLabelManagerUI.3(this));
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, ContactLabelEditUI.class);
    localIntent.putExtra("label_id", paramMenuItem.field_labelID);
    localIntent.putExtra("label_name", paramMenuItem.field_labelName);
    localIntent.putExtra("label_source", "label_source_Address");
    startActivity(localIntent);
  }
  
  protected void onPause()
  {
    au.Dk().b(636, this);
    au.Hx();
    com.tencent.mm.model.c.Fw().b(this.lBv);
    super.onPause();
  }
  
  protected void onResume()
  {
    au.Dk().a(636, this);
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this.lBv);
    hf(true);
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    default: 
      y.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Gt(((b)paramm).lAN);
      return;
    }
    y.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
    bdH();
  }
  
  final class a
    extends BaseAdapter
  {
    ArrayList<af> mData;
    
    a() {}
    
    public final int getCount()
    {
      if (this.mData == null) {
        return 0;
      }
      return this.mData.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(ContactLabelManagerUI.this).inflate(R.i.contact_label_list_item, paramViewGroup, false);
        paramViewGroup = new c(paramView);
        localObject = paramViewGroup.lCs.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cb.a.ab(ContactLabelManagerUI.this, R.f.SmallListHeight) * com.tencent.mm.cb.a.fg(ContactLabelManagerUI.this)));
        paramViewGroup.lCs.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = sW(paramInt);
        SpannableString localSpannableString = j.b(ContactLabelManagerUI.this.mController.uMN, ((af)localObject).field_labelName, ContactLabelManagerUI.l(ContactLabelManagerUI.this));
        paramViewGroup.lCq.setText(localSpannableString);
        if ((ContactLabelManagerUI.j(ContactLabelManagerUI.this) == null) || (!ContactLabelManagerUI.j(ContactLabelManagerUI.this).containsKey(Integer.valueOf(((af)localObject).field_labelID)))) {
          break;
        }
        paramViewGroup.lCr.setVisibility(0);
        paramViewGroup.lCr.setText("(" + ContactLabelManagerUI.j(ContactLabelManagerUI.this).get(Integer.valueOf(((af)localObject).field_labelID)) + ")");
        return paramView;
        paramViewGroup = (c)paramView.getTag();
      }
      paramViewGroup.lCr.setVisibility(0);
      paramViewGroup.lCr.setText("(0)");
      return paramView;
    }
    
    public final af sW(int paramInt)
    {
      if ((this.mData == null) || (paramInt > this.mData.size())) {
        return null;
      }
      return (af)this.mData.get(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI
 * JD-Core Version:    0.7.0.1
 */