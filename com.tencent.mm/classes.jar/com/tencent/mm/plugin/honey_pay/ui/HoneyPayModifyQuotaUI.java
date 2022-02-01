package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayModifyQuotaUI
  extends HoneyPayBaseUI
{
  private Button lKB;
  private String tCZ;
  private long tDO;
  private long tDP;
  private WalletFormView tEH;
  private TextView tEn;
  
  private void mY(boolean paramBoolean)
  {
    AppMethodBeat.i(64809);
    if ((paramBoolean) && (!this.tEn.isShown()))
    {
      String str = ah.fAw() + e.a(new StringBuilder().append(this.tDP).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.tEn.setText(getString(2131760286, new Object[] { str }));
      this.tEn.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.tEn.setVisibility(0);
      AppMethodBeat.o(64809);
      return;
    }
    if ((!paramBoolean) && (this.tEn.isShown()))
    {
      this.tEn.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.tEn.setVisibility(8);
    }
    AppMethodBeat.o(64809);
  }
  
  private void mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(64810);
    if ((paramBoolean) && (!this.tEn.isShown()))
    {
      String str = ah.fAw() + e.a(new StringBuilder().append(this.tDO).toString(), "100", 2, RoundingMode.HALF_UP);
      this.tEn.setText(getString(2131760282, new Object[] { str }));
      this.tEn.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.tEn.setVisibility(0);
      AppMethodBeat.o(64810);
      return;
    }
    if ((!paramBoolean) && (this.tEn.isShown()))
    {
      this.tEn.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.tEn.setVisibility(8);
    }
    AppMethodBeat.o(64810);
  }
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(64811);
    this.lKB.setEnabled(paramBoolean);
    AppMethodBeat.o(64811);
  }
  
  public int getLayoutId()
  {
    return 2131494450;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64806);
    this.tEH = ((WalletFormView)findViewById(2131300834));
    this.lKB = ((Button)findViewById(2131300833));
    this.tEn = ((TextView)findViewById(2131300835));
    this.tEH.setContentPadding$3b4dfe4b(0);
    this.tEH.getTitleTv().setText(ah.fAw());
    setEditFocusListener(this.tEH, 2, false);
    this.tEH.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64802);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 2)) {
          paramAnonymousEditable.delete(i + 3, j);
        }
        HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this);
        AppMethodBeat.o(64802);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.lKB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64803);
        if (HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this))
        {
          HoneyPayModifyQuotaUI.b(HoneyPayModifyQuotaUI.this);
          HoneyPayModifyQuotaUI.this.hideTenpayKB();
        }
        AppMethodBeat.o(64803);
      }
    });
    this.tEH.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64804);
        HoneyPayModifyQuotaUI.c(HoneyPayModifyQuotaUI.this).d(HoneyPayModifyQuotaUI.this);
        AppMethodBeat.o(64804);
      }
    }, 100L);
    AppMethodBeat.o(64806);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64808);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
    {
      setResult(-1, paramIntent);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(64808);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64805);
    super.onCreate(paramBundle);
    this.tDO = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.tDP = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.tCZ = getIntent().getStringExtra("key_card_no");
    initView();
    setMMTitle(2131760287);
    AppMethodBeat.o(64805);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64807);
    super.onDestroy();
    AppMethodBeat.o(64807);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI
 * JD-Core Version:    0.7.0.1
 */