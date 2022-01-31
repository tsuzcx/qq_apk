package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPaySelectCardTypeUI
  extends HoneyPayBaseUI
{
  private LinearLayout nJI;
  private List<aua> nJJ;
  private int nJK;
  private aub nJL;
  
  private void refreshView()
  {
    AppMethodBeat.i(41961);
    this.nJI.removeAllViews();
    if ((this.nJJ == null) || (this.nJJ.isEmpty()))
    {
      AppMethodBeat.o(41961);
      return;
    }
    Iterator localIterator = this.nJJ.iterator();
    if (localIterator.hasNext())
    {
      aua localaua = (aua)localIterator.next();
      HoneyPaySelectCardTypeUI.a locala = new HoneyPaySelectCardTypeUI.a(this, (byte)0);
      Object localObject1;
      Object localObject2;
      if (localaua.xch == null)
      {
        localObject1 = getContext();
        localObject2 = this.nJI;
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(2130969876, (ViewGroup)localObject2, false);
        locala.a((View)localObject1, localaua);
      }
      for (;;)
      {
        this.nJI.addView((View)localObject1);
        break;
        localObject2 = getContext();
        localObject1 = this.nJI;
        localObject1 = LayoutInflater.from((Context)localObject2).inflate(2130969877, (ViewGroup)localObject1, false);
        locala.a((View)localObject1, localaua);
        locala.nHP = ((CdnImageView)((View)localObject1).findViewById(2131825078));
        locala.nJP = ((TextView)((View)localObject1).findViewById(2131825079));
        locala.nHP.setUrl(localaua.xch.cDz);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localaua.xch.xiQ);
        localSpannableStringBuilder.append(localaua.xch.xiR);
        localSpannableStringBuilder.setSpan(new o(new HoneyPaySelectCardTypeUI.a.1(locala, localaua, (Context)localObject2)), localaua.xch.xiQ.length(), localSpannableStringBuilder.length(), 34);
        locala.nJP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m((Context)localObject2));
        locala.nJP.setClickable(true);
        locala.nJP.setText(localSpannableStringBuilder);
      }
    }
    AppMethodBeat.o(41961);
  }
  
  public int getLayoutId()
  {
    return 2130969878;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41957);
    this.nJI = ((LinearLayout)$(2131825080));
    AppMethodBeat.o(41957);
  }
  
  public boolean needExecuteBackListener()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41960);
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label101;
      }
      Object localObject = paramIntent.getStringExtra("Select_Conv_User");
      ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", new Object[] { localObject });
      ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", new Object[] { localObject });
      localObject = new b((String)localObject, this.nJK);
      ((b)localObject).o(this);
      doSceneProgress((com.tencent.mm.ai.m)localObject, true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(41960);
      return;
      label101:
      ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41956);
    this.nHx = 2131690170;
    super.onCreate(paramBundle);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    setMMTitle(2131300709);
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.nJJ = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          aua localaua = new aua();
          localaua.parseFrom(localHoneyPayCardType.pW);
          this.nJJ.add(localaua);
        }
        initView();
      }
      catch (IOException paramBundle)
      {
        ab.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", paramBundle, "", new Object[0]);
      }
    }
    refreshView();
    AppMethodBeat.o(41956);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41958);
    removeSceneEndListener(2618);
    removeSceneEndListener(2926);
    super.onDestroy();
    AppMethodBeat.o(41958);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41959);
    if ((paramm instanceof b))
    {
      paramString = (b)paramm;
      paramString.a(new HoneyPaySelectCardTypeUI.3(this, paramString)).b(new HoneyPaySelectCardTypeUI.2(this)).c(new HoneyPaySelectCardTypeUI.1(this));
    }
    AppMethodBeat.o(41959);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI
 * JD-Core Version:    0.7.0.1
 */