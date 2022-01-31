package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;

public class LocationExtUI
  extends MMActivity
{
  private ArrayList<String> lru;
  private TextView obZ;
  private TextView oca;
  private String ocb;
  
  public LocationExtUI()
  {
    AppMethodBeat.i(113435);
    this.lru = new ArrayList();
    AppMethodBeat.o(113435);
  }
  
  public int getLayoutId()
  {
    return 2130969991;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113437);
    if (4097 == paramInt1)
    {
      if ((-1 != paramInt2) || (paramIntent == null))
      {
        AppMethodBeat.o(113437);
        return;
      }
      paramIntent = paramIntent.getCharSequenceExtra("key_result");
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.toString())
      {
        this.ocb = paramIntent;
        this.oca.setText(this.ocb);
        AppMethodBeat.o(113437);
        return;
      }
    }
    if (4098 == paramInt1)
    {
      if ((-1 != paramInt2) || (paramIntent == null))
      {
        AppMethodBeat.o(113437);
        return;
      }
      this.lru.clear();
      String[] arrayOfString = paramIntent.getStringArrayExtra("key_fav_result_array");
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(113437);
        return;
      }
      paramIntent = arrayOfString[0];
      this.lru.add(arrayOfString[0]);
      String str = getResources().getString(2131299844);
      paramInt1 = 1;
      while (paramInt1 < arrayOfString.length)
      {
        this.lru.add(arrayOfString[paramInt1]);
        paramIntent = paramIntent + str + arrayOfString[paramInt1];
        paramInt1 += 1;
      }
      this.obZ.setText(paramIntent);
      AppMethodBeat.o(113437);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(113437);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113436);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Kwebmap_locaion");
    if (bo.isNullOrNil(paramBundle)) {
      findViewById(2131825431).setVisibility(8);
    }
    for (;;)
    {
      this.obZ = ((TextView)findViewById(2131825430));
      this.oca = ((TextView)findViewById(2131825429));
      this.obZ.setOnClickListener(new LocationExtUI.1(this));
      this.oca.setOnClickListener(new LocationExtUI.2(this));
      addTextOptionMenu(0, getString(2131296964), new LocationExtUI.3(this), null, q.b.zby);
      setBackBtn(new LocationExtUI.4(this));
      AppMethodBeat.o(113436);
      return;
      ((TextView)findViewById(2131825432)).setText(paramBundle);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI
 * JD-Core Version:    0.7.0.1
 */