package com.tencent.mm.plugin.lite.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.luggage.f.a.b;
import com.tencent.luggage.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.api.c;
import com.tencent.mm.plugin.lite.logic.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxaLiteAppListUI
  extends MMActivity
{
  private static Map<String, String> KbI;
  private static String TAG;
  private ListView KbD;
  private a KbE;
  private c KbF;
  private TextView KbG;
  private TextView KbH;
  private ListView mListView;
  
  static
  {
    AppMethodBeat.i(271423);
    TAG = "MicroMsg.WxaLiteAppListUI";
    KbI = new HashMap() {};
    AppMethodBeat.o(271423);
  }
  
  public int getLayoutId()
  {
    return a.c.lite_app_list_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(271438);
    super.onCreate(paramBundle);
    this.KbG = ((TextView)findViewById(a.b.baselibDesc));
    paramBundle = d.fUn();
    this.KbG.setText("基础库列表  当前基础库大版本：".concat(String.valueOf(paramBundle)));
    this.KbH = ((TextView)findViewById(a.b.appDesc));
    this.KbH.setText("App列表");
    this.KbD = ((ListView)findViewById(a.b.baselibList));
    this.KbE = new a();
    this.KbD.setAdapter(this.KbE);
    this.mListView = ((ListView)findViewById(a.b.appList));
    this.KbF = new c();
    this.mListView.setAdapter(this.KbF);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(271440);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = WxaLiteAppListUI.a(WxaLiteAppListUI.this).ZB(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("appId", paramAnonymousAdapterView.appId);
          if (!"wxalitebaselibrary".equals(paramAnonymousAdapterView.appId)) {
            ((c)h.ax(c.class)).a(MMApplicationContext.getContext(), paramAnonymousView, false, true, null);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(271440);
          return;
          Toast.makeText(WxaLiteAppListUI.this.getContext(), "Is Base Lib ", 0).show();
          continue;
          Log.d(WxaLiteAppListUI.TAG, "info is null.");
        }
      }
    });
    this.mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(271449);
        paramAnonymousAdapterView = WxaLiteAppListUI.a(WxaLiteAppListUI.this).ZB(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("appId", paramAnonymousAdapterView.appId);
          paramAnonymousView.putString("mode", "bottom_sheet");
          paramAnonymousView.putInt("sheet_height", com.tencent.mm.cd.a.mt(WxaLiteAppListUI.this.getContext()) / 2);
          if (!"wxalitebaselibrary".equals(paramAnonymousAdapterView.appId)) {
            ((c)h.ax(c.class)).a(MMApplicationContext.getContext(), paramAnonymousView, false, true, null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(271449);
          return false;
          Toast.makeText(WxaLiteAppListUI.this.getContext(), "Is Base Lib ", 0).show();
          continue;
          Log.d(WxaLiteAppListUI.TAG, "info is null.");
        }
      }
    });
    AppMethodBeat.o(271438);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(271446);
    super.onResume();
    String str = d.fUn();
    this.KbG.setText("基础库列表  当前基础库大版本：".concat(String.valueOf(str)));
    this.KbF.notifyDataSetChanged();
    AppMethodBeat.o(271446);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private List<WxaLiteAppBaselibInfo> xGG;
    
    a()
    {
      AppMethodBeat.i(271402);
      d.fUi();
      Bundle localBundle = MMApplicationContext.getContext().getContentResolver().call(d.getUri(), "getLiteAppBaselibList", null, null);
      if (localBundle == null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "getLiteAppBaselibList bundle is null.");
        this$1 = localObject;
      }
      for (;;)
      {
        this.xGG = WxaLiteAppListUI.this;
        AppMethodBeat.o(271402);
        return;
        localBundle.setClassLoader(WxaLiteAppBaselibInfo.class.getClassLoader());
        this$1 = localObject;
        if (localBundle.containsKey("LiteAppBaselibList")) {
          this$1 = localBundle.getParcelableArrayList("LiteAppBaselibList");
        }
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(271410);
      if (this.xGG == null)
      {
        AppMethodBeat.o(271410);
        return 0;
      }
      int i = this.xGG.size();
      AppMethodBeat.o(271410);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(271425);
      WxaLiteAppBaselibInfo localWxaLiteAppBaselibInfo = (WxaLiteAppBaselibInfo)this.xGG.get(paramInt);
      Object localObject;
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localObject = (WxaLiteAppListUI.b)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      for (;;)
      {
        localObject = "基础库 大版本号：" + localWxaLiteAppBaselibInfo.egH;
        paramView.dyR.setText((CharSequence)localObject);
        paramView.KbK.setText("");
        AppMethodBeat.o(271425);
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(WxaLiteAppListUI.this.getContext()).inflate(a.c.lite_app_list_item, null, false);
        paramView = new WxaLiteAppListUI.b(WxaLiteAppListUI.this, paramViewGroup);
        paramViewGroup.setTag(paramView);
      }
    }
  }
  
  final class b
  {
    public TextView KbK;
    public TextView dyR;
    
    public b(View paramView)
    {
      AppMethodBeat.i(271400);
      this.dyR = ((TextView)paramView.findViewById(a.b.title));
      this.KbK = ((TextView)paramView.findViewById(a.b.subTitle));
      AppMethodBeat.o(271400);
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private List<WxaLiteAppInfo> xGG;
    
    c()
    {
      AppMethodBeat.i(271404);
      d.fUi();
      this.xGG = d.fUk();
      AppMethodBeat.o(271404);
    }
    
    public final WxaLiteAppInfo ZB(int paramInt)
    {
      AppMethodBeat.i(271420);
      if ((this.xGG != null) && (this.xGG.size() > paramInt))
      {
        WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)this.xGG.get(paramInt);
        AppMethodBeat.o(271420);
        return localWxaLiteAppInfo;
      }
      AppMethodBeat.o(271420);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(271411);
      if (this.xGG == null)
      {
        AppMethodBeat.o(271411);
        return 0;
      }
      int i = this.xGG.size();
      AppMethodBeat.o(271411);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(271434);
      WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)this.xGG.get(paramInt);
      Object localObject;
      String str1;
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localObject = (WxaLiteAppListUI.b)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
        str1 = localWxaLiteAppInfo.appId;
        String str2 = d.aC(localWxaLiteAppInfo.appId, localWxaLiteAppInfo.path, localWxaLiteAppInfo.egI);
        if (str2 != null)
        {
          localObject = str2;
          if (str2.length() != 0) {}
        }
        else
        {
          localObject = "undefined";
        }
        if (!WxaLiteAppListUI.aPI().containsKey(localWxaLiteAppInfo.appId)) {
          break label200;
        }
        str1 = (String)WxaLiteAppListUI.aPI().get(localWxaLiteAppInfo.appId);
      }
      label200:
      for (;;)
      {
        paramView.dyR.setText(str1);
        paramView.KbK.setText("minBaselibMajorVersion: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(271434);
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(WxaLiteAppListUI.this.getContext()).inflate(a.c.lite_app_list_item, null, false);
        paramView = new WxaLiteAppListUI.b(WxaLiteAppListUI.this, paramViewGroup);
        paramViewGroup.setTag(paramView);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppListUI
 * JD-Core Version:    0.7.0.1
 */