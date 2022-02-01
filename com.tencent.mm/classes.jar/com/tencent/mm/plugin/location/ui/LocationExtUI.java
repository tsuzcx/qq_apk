package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;

public class LocationExtUI
  extends MMActivity
{
  private TextView Elq;
  private TextView Elr;
  private String Els;
  private ArrayList<String> uPE;
  
  public LocationExtUI()
  {
    AppMethodBeat.i(55812);
    this.uPE = new ArrayList();
    AppMethodBeat.o(55812);
  }
  
  public int getLayoutId()
  {
    return a.f.location_ext_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(55814);
    if (4097 == paramInt1)
    {
      if ((-1 != paramInt2) || (paramIntent == null))
      {
        AppMethodBeat.o(55814);
        return;
      }
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.Els = paramIntent;
        this.Elr.setText(this.Els);
        AppMethodBeat.o(55814);
        return;
      }
    }
    if (4098 == paramInt1)
    {
      if ((-1 != paramInt2) || (paramIntent == null))
      {
        AppMethodBeat.o(55814);
        return;
      }
      this.uPE.clear();
      String[] arrayOfString = paramIntent.getStringArrayExtra("key_fav_result_array");
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(55814);
        return;
      }
      paramIntent = arrayOfString[0];
      this.uPE.add(arrayOfString[0]);
      String str = getResources().getString(a.i.favorite_tag_delimiter_1);
      paramInt1 = 1;
      while (paramInt1 < arrayOfString.length)
      {
        this.uPE.add(arrayOfString[paramInt1]);
        paramIntent = paramIntent + str + arrayOfString[paramInt1];
        paramInt1 += 1;
      }
      this.Elq.setText(paramIntent);
      AppMethodBeat.o(55814);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(55814);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55813);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Kwebmap_locaion");
    if (Util.isNullOrNil(paramBundle)) {
      findViewById(a.e.location_info_ll).setVisibility(8);
    }
    for (;;)
    {
      this.Elq = ((TextView)findViewById(a.e.tag_tv));
      this.Elr = ((TextView)findViewById(a.e.remard_tv));
      this.Elq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(55808);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/location/ui/LocationExtUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_fav_result_list", LocationExtUI.a(LocationExtUI.this));
          com.tencent.mm.plugin.fav.a.b.a(LocationExtUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymousView, 4098);
          a.a(this, "com/tencent/mm/plugin/location/ui/LocationExtUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(55808);
        }
      });
      this.Elr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(55809);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/location/ui/LocationExtUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent(LocationExtUI.this.getContext(), RemarkUI.class);
          paramAnonymousView.putExtra("key_nullable", true);
          paramAnonymousView.putExtra("key_value", LocationExtUI.this.getIntent().getStringExtra("key_value"));
          paramAnonymousView.putExtra("key_hint", LocationExtUI.this.getString(a.i.location_remark_hint));
          paramAnonymousView.putExtra("Kwebmap_locaion", LocationExtUI.this.getIntent().getStringExtra("Kwebmap_locaion"));
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", a.a.push_down_out);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", a.a.fast_faded_in);
          paramAnonymousView.putExtra("kFavInfoLocalId", LocationExtUI.this.getIntent().getLongExtra("kFavInfoLocalId", -1L));
          paramAnonymousView.putExtra("kRemark", LocationExtUI.this.getIntent().getStringExtra("kRemark"));
          LocationExtUI.this.startActivityForResult(paramAnonymousView, 4097);
          a.a(this, "com/tencent/mm/plugin/location/ui/LocationExtUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(55809);
        }
      });
      addTextOptionMenu(0, getString(a.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(55810);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("key_remark_result", LocationExtUI.b(LocationExtUI.this));
          paramAnonymousMenuItem.putExtra("key_tags_result", LocationExtUI.a(LocationExtUI.this));
          LocationExtUI.this.setResult(-1, paramAnonymousMenuItem);
          LocationExtUI.this.finish();
          AppMethodBeat.o(55810);
          return true;
        }
      }, null, w.b.Wao);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(55811);
          LocationExtUI.this.finish();
          AppMethodBeat.o(55811);
          return true;
        }
      });
      AppMethodBeat.o(55813);
      return;
      ((TextView)findViewById(a.e.location_text_tv)).setText(paramBundle);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI
 * JD-Core Version:    0.7.0.1
 */