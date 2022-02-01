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
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;

public class LocationExtUI
  extends MMActivity
{
  private ArrayList<String> oHO;
  private TextView sQA;
  private String sQB;
  private TextView sQz;
  
  public LocationExtUI()
  {
    AppMethodBeat.i(55812);
    this.oHO = new ArrayList();
    AppMethodBeat.o(55812);
  }
  
  public int getLayoutId()
  {
    return 2131494595;
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
        this.sQB = paramIntent;
        this.sQA.setText(this.sQB);
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
      this.oHO.clear();
      String[] arrayOfString = paramIntent.getStringArrayExtra("key_fav_result_array");
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(55814);
        return;
      }
      paramIntent = arrayOfString[0];
      this.oHO.add(arrayOfString[0]);
      String str = getResources().getString(2131759020);
      paramInt1 = 1;
      while (paramInt1 < arrayOfString.length)
      {
        this.oHO.add(arrayOfString[paramInt1]);
        paramIntent = paramIntent + str + arrayOfString[paramInt1];
        paramInt1 += 1;
      }
      this.sQz.setText(paramIntent);
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
    if (bt.isNullOrNil(paramBundle)) {
      findViewById(2131301528).setVisibility(8);
    }
    for (;;)
    {
      this.sQz = ((TextView)findViewById(2131305635));
      this.sQA = ((TextView)findViewById(2131303977));
      this.sQz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(55808);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_fav_result_list", LocationExtUI.a(LocationExtUI.this));
          b.a(LocationExtUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymousView, 4098);
          AppMethodBeat.o(55808);
        }
      });
      this.sQA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(55809);
          paramAnonymousView = new Intent(LocationExtUI.this.getContext(), RemarkUI.class);
          paramAnonymousView.putExtra("key_nullable", true);
          paramAnonymousView.putExtra("key_value", LocationExtUI.this.getIntent().getStringExtra("key_value"));
          paramAnonymousView.putExtra("key_hint", LocationExtUI.this.getString(2131760726));
          paramAnonymousView.putExtra("Kwebmap_locaion", LocationExtUI.this.getIntent().getStringExtra("Kwebmap_locaion"));
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
          paramAnonymousView.putExtra("kFavInfoLocalId", LocationExtUI.this.getIntent().getLongExtra("kFavInfoLocalId", -1L));
          paramAnonymousView.putExtra("kRemark", LocationExtUI.this.getIntent().getStringExtra("kRemark"));
          LocationExtUI.this.startActivityForResult(paramAnonymousView, 4097);
          AppMethodBeat.o(55809);
        }
      });
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
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
      }, null, r.b.FOB);
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
      ((TextView)findViewById(2131301544)).setText(paramBundle);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI
 * JD-Core Version:    0.7.0.1
 */