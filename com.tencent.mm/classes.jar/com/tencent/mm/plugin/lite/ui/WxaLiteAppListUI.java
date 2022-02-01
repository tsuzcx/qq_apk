package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
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
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.luggage.f.a.b;
import com.tencent.luggage.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxaLiteAppListUI
  extends MMActivity
{
  private static Map<String, String> Ehc;
  private static String TAG;
  private b Ehb;
  private ListView mListView;
  
  static
  {
    AppMethodBeat.i(233594);
    TAG = "MicroMsg.WxaLiteAppListUI";
    Ehc = new HashMap() {};
    AppMethodBeat.o(233594);
  }
  
  public int getLayoutId()
  {
    return a.c.lite_app_list_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233590);
    super.onCreate(paramBundle);
    this.mListView = ((ListView)findViewById(a.b.list));
    this.Ehb = new b();
    this.mListView.setAdapter(this.Ehb);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(233753);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = WxaLiteAppListUI.a(WxaLiteAppListUI.this).VF(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("appId", paramAnonymousAdapterView.appId);
          if (!"wxalitebaselibrary".equals(paramAnonymousAdapterView.appId)) {
            ((com.tencent.mm.plugin.lite.a.a)h.ae(com.tencent.mm.plugin.lite.a.a.class)).a(MMApplicationContext.getContext(), paramAnonymousView, false, null);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(233753);
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
        AppMethodBeat.i(233907);
        paramAnonymousAdapterView = WxaLiteAppListUI.a(WxaLiteAppListUI.this).VF(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("appId", paramAnonymousAdapterView.appId);
          paramAnonymousView.putString("mode", "bottom_sheet");
          paramAnonymousView.putInt("sheet_height", com.tencent.mm.ci.a.ks(WxaLiteAppListUI.this.getContext()) / 2);
          if (!"wxalitebaselibrary".equals(paramAnonymousAdapterView.appId)) {
            ((com.tencent.mm.plugin.lite.a.a)h.ae(com.tencent.mm.plugin.lite.a.a.class)).a(MMApplicationContext.getContext(), paramAnonymousView, false, null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(233907);
          return false;
          Toast.makeText(WxaLiteAppListUI.this.getContext(), "Is Base Lib ", 0).show();
          continue;
          Log.d(WxaLiteAppListUI.TAG, "info is null.");
        }
      }
    });
    AppMethodBeat.o(233590);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    public TextView bFR;
    
    public a(View paramView)
    {
      AppMethodBeat.i(233756);
      this.bFR = ((TextView)paramView.findViewById(a.b.title));
      AppMethodBeat.o(233756);
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<WxaLiteAppInfo> uAd;
    
    b()
    {
      AppMethodBeat.i(234123);
      f.eLH();
      this.uAd = f.eLI();
      AppMethodBeat.o(234123);
    }
    
    public final WxaLiteAppInfo VF(int paramInt)
    {
      AppMethodBeat.i(234127);
      if ((this.uAd != null) && (this.uAd.size() > paramInt))
      {
        WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)this.uAd.get(paramInt);
        AppMethodBeat.o(234127);
        return localWxaLiteAppInfo;
      }
      AppMethodBeat.o(234127);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(234126);
      if (this.uAd == null)
      {
        AppMethodBeat.o(234126);
        return 0;
      }
      int i = this.uAd.size();
      AppMethodBeat.o(234126);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(234131);
      WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)this.uAd.get(paramInt);
      Object localObject;
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localObject = (WxaLiteAppListUI.a)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
        localObject = localWxaLiteAppInfo.appId;
        if (!WxaLiteAppListUI.avp().containsKey(localWxaLiteAppInfo.appId)) {
          break label142;
        }
        localObject = (String)WxaLiteAppListUI.avp().get(localWxaLiteAppInfo.appId);
      }
      label142:
      for (;;)
      {
        paramView.bFR.setText((CharSequence)localObject);
        AppMethodBeat.o(234131);
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(WxaLiteAppListUI.this.getContext()).inflate(a.c.lite_app_list_item, null, false);
        paramView = new WxaLiteAppListUI.a(WxaLiteAppListUI.this, paramViewGroup);
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