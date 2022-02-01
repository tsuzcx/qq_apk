package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
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
  private static String TAG;
  private static Map<String, String> yFk;
  private ListView mListView;
  private b yFj;
  
  static
  {
    AppMethodBeat.i(198948);
    TAG = "MicroMsg.WxaLiteAppListUI";
    yFk = new HashMap() {};
    AppMethodBeat.o(198948);
  }
  
  public int getLayoutId()
  {
    return 2131495218;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198947);
    super.onCreate(paramBundle);
    this.mListView = ((ListView)findViewById(2131303226));
    this.yFj = new b();
    this.mListView.setAdapter(this.yFj);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(198940);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = WxaLiteAppListUI.a(WxaLiteAppListUI.this).Pw(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("appId", paramAnonymousAdapterView.appId);
          if (!"wxalitebaselibrary".equals(paramAnonymousAdapterView.appId)) {
            ((com.tencent.mm.plugin.lite.a.a)g.af(com.tencent.mm.plugin.lite.a.a.class)).a(MMApplicationContext.getContext(), paramAnonymousView, false, null);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(198940);
          return;
          Toast.makeText(WxaLiteAppListUI.this.getContext(), "Is Base Lib ", 0).show();
          continue;
          Log.d(WxaLiteAppListUI.TAG, "info is null.");
        }
      }
    });
    AppMethodBeat.o(198947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    public TextView vr;
    
    public a(View paramView)
    {
      AppMethodBeat.i(198941);
      this.vr = ((TextView)paramView.findViewById(2131309195));
      AppMethodBeat.o(198941);
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<WxaLiteAppInfo> qXp;
    
    b()
    {
      AppMethodBeat.i(198942);
      f.ecC();
      this.qXp = f.ecD();
      AppMethodBeat.o(198942);
    }
    
    public final WxaLiteAppInfo Pw(int paramInt)
    {
      AppMethodBeat.i(198944);
      if ((this.qXp != null) && (this.qXp.size() > paramInt))
      {
        WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)this.qXp.get(paramInt);
        AppMethodBeat.o(198944);
        return localWxaLiteAppInfo;
      }
      AppMethodBeat.o(198944);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(198943);
      if (this.qXp == null)
      {
        AppMethodBeat.o(198943);
        return 0;
      }
      int i = this.qXp.size();
      AppMethodBeat.o(198943);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(198945);
      WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)this.qXp.get(paramInt);
      Object localObject;
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localObject = (WxaLiteAppListUI.a)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
        localObject = localWxaLiteAppInfo.appId;
        if (!WxaLiteAppListUI.apc().containsKey(localWxaLiteAppInfo.appId)) {
          break label141;
        }
        localObject = (String)WxaLiteAppListUI.apc().get(localWxaLiteAppInfo.appId);
      }
      label141:
      for (;;)
      {
        paramView.vr.setText((CharSequence)localObject);
        AppMethodBeat.o(198945);
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(WxaLiteAppListUI.this.getContext()).inflate(2131495217, null, false);
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