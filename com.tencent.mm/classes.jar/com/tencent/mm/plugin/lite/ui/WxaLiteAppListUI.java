package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.logic.ParcelableLiteAppInfo;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class WxaLiteAppListUI
  extends MMActivity
{
  private static String TAG = "MicroMsg.WxaLiteAppListUI";
  private ListView mListView;
  private b vle;
  
  public int getLayoutId()
  {
    return 2131496526;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217829);
    super.onCreate(paramBundle);
    this.mListView = ((ListView)findViewById(2131301443));
    this.vle = new b();
    this.mListView.setAdapter(this.vle);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(217822);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = WxaLiteAppListUI.a(WxaLiteAppListUI.this).Ju(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("appId", paramAnonymousAdapterView.field_appId);
          if (!"wxalitebaselibrary".equals(paramAnonymousAdapterView.field_appId)) {
            ((com.tencent.mm.plugin.lite.a.a)g.ab(com.tencent.mm.plugin.lite.a.a.class)).a(ak.getContext(), paramAnonymousView, false, null);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(217822);
          return;
          Toast.makeText(WxaLiteAppListUI.this.getContext(), "Is Base Lib ", 0).show();
          continue;
          ae.d(WxaLiteAppListUI.TAG, "info is null.");
        }
      }
    });
    AppMethodBeat.o(217829);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    public TextView vk;
    
    public a(View paramView)
    {
      AppMethodBeat.i(217823);
      this.vk = ((TextView)paramView.findViewById(2131305902));
      AppMethodBeat.o(217823);
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<ParcelableLiteAppInfo> pHD;
    
    b()
    {
      AppMethodBeat.i(217824);
      c.diz();
      this.pHD = ak.getContext().getContentResolver().call(c.getUri(), "getLiteAppList", null, null).getParcelableArrayList("result");
      AppMethodBeat.o(217824);
    }
    
    public final ParcelableLiteAppInfo Ju(int paramInt)
    {
      AppMethodBeat.i(217826);
      if ((this.pHD != null) && (this.pHD.size() > paramInt))
      {
        ParcelableLiteAppInfo localParcelableLiteAppInfo = (ParcelableLiteAppInfo)this.pHD.get(paramInt);
        AppMethodBeat.o(217826);
        return localParcelableLiteAppInfo;
      }
      AppMethodBeat.o(217826);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(217825);
      if (this.pHD == null)
      {
        AppMethodBeat.o(217825);
        return 0;
      }
      int i = this.pHD.size();
      AppMethodBeat.o(217825);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(217827);
      ParcelableLiteAppInfo localParcelableLiteAppInfo = (ParcelableLiteAppInfo)this.pHD.get(paramInt);
      if ((paramView != null) && (paramView.getTag() != null))
      {
        WxaLiteAppListUI.a locala = (WxaLiteAppListUI.a)paramView.getTag();
        paramViewGroup = paramView;
        paramView = locala;
      }
      for (;;)
      {
        paramView.vk.setText(localParcelableLiteAppInfo.field_appId);
        AppMethodBeat.o(217827);
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(WxaLiteAppListUI.this.getContext()).inflate(2131496525, null, false);
        paramView = new WxaLiteAppListUI.a(WxaLiteAppListUI.this, paramViewGroup);
        paramViewGroup.setTag(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppListUI
 * JD-Core Version:    0.7.0.1
 */